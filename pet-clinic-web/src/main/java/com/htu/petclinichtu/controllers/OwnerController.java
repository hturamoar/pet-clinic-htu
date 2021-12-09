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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.htu.petclinichtu.models.Owner;
import com.htu.petclinichtu.services.OwnerService;

@RequestMapping("/owners")
@Controller
public class OwnerController {

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
		List<Owner> ownersResults = ownerService.findByLastNameLike(lastName);
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
	public ModelAndView showOwner(@PathVariable("ownerId") Long ownerId) {
		ModelAndView mav = new ModelAndView("/owners/ownerDetails");
		mav.addObject(ownerService.findById(ownerId));
		return mav;
	}
	
}
