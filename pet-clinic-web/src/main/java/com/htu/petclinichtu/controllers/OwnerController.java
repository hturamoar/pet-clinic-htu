package com.htu.petclinichtu.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;

import com.htu.petclinichtu.models.Owner;
import com.htu.petclinichtu.services.OwnerService;

@RequestMapping("/owners")
@Controller
public class OwnerController {
	
	private static final String VIEWS_OWNER_CREATE_OR_UPDATE_FORM = "owners/createOrUpdateOwnerForm";

	private final OwnerService ownerService;

	@InitBinder
	public void setAllowedFields(WebDataBinder webDataBinder) {
		webDataBinder.setDisallowedFields("id");
	}

	public OwnerController(OwnerService ownerService) {
		super();
		this.ownerService = ownerService;
	}

	@GetMapping
	public String processForm(Owner owner, BindingResult result, Model model) {
		// allow parameterless GET request for /owners to return all records
		if (owner.getLastName() == null) {
			owner.setLastName(""); // empty string signifies broadest possible search
		}

		// find owners by last name
		String lastName = owner.getLastName();
		List<Owner> ownersResults = ownerService.findAllByLastNameLike("%"+lastName+"%");
		if (ownersResults.isEmpty()) {
			// no owners found
			result.rejectValue("lastName", "notFound", "not found");
			return "owners/findOwners";
		} else if (ownersResults.size() == 1) {
			// 1 owner found
			owner = ownersResults.iterator().next();
			return "redirect:/owners/" + owner.getId();
		} else {
			// multiple owners found
			lastName = owner.getLastName();
			model.addAttribute("listOwners",ownersResults);
			return "owners/ownersList";
		}
	}

	@RequestMapping("/find")
	public String findOwners(Map<String, Object> model) {
		model.put("owner", new Owner());
		return "owners/findOwners";
	}

	@GetMapping("/{ownerId}")
	public ModelAndView showOwner(@PathVariable Long ownerId) {
		ModelAndView mav = new ModelAndView("/owners/ownerDetails");
		mav.addObject(ownerService.findById(ownerId));
		return mav;
	}
	
	@GetMapping("/new")
	public String initCreationForm(Model model) {
		Owner owner = new Owner();
		model.addAttribute("owner",owner);
		return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
	}
	
	@PostMapping("new")
	public String processCreationForm(@Valid Owner owner,BindingResult result) {
		if (result.hasErrors()) {
			return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
		}else {
		return "redirect:/owners/" + ownerService.save(owner).getId();
		}
	}
	
	@GetMapping("/{ownerId}/edit")
	public String initUpdateOwnerForm(@PathVariable Long ownerId, Model model) {
		model.addAttribute(ownerService.findById(ownerId));
		return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
	}

	@PostMapping("/{ownerId}/edit")
	public String processUpdateOwnerForm(@Valid Owner owner, BindingResult result,
			@PathVariable("ownerId") Long ownerId) {
		if (result.hasErrors()) {
			return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
		}
		else {
			owner.setId(ownerId);
			ownerService.save(owner);
			return "redirect:/owners/"+ownerService.save(owner).getId();
		}
	}
	
}
