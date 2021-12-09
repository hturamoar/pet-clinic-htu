package com.htu.petclinichtu.controllers;

import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.htu.petclinichtu.models.Owner;
import com.htu.petclinichtu.models.PetType;
import com.htu.petclinichtu.services.OwnerService;
import com.htu.petclinichtu.services.PetService;
import com.htu.petclinichtu.services.PetTypeService;

@Controller
@RequestMapping("/owners/{ownerId}")
public class PetController {
	
	private static final String VIEWS_PETS_CREATE_OR_UPDATE_FORM = "pets/createOrUpdatePetForm";
	
	private final PetService petService;
	private final OwnerService ownerService;
	private final PetTypeService petTypeService;
	
	
	public PetController(PetService petService, OwnerService ownerService,PetTypeService petTypeService) {
		super();
		this.petService = petService;
		this.ownerService = ownerService;
		this.petTypeService = petTypeService;
	}

	@ModelAttribute("types")
	public Collection<PetType> populatePetTypes(){
		return petTypeService.findAll();
	}
	
	@ModelAttribute("owner")
	public Owner findOwner(@PathVariable("ownerId") Long ownerId){
		return ownerService.findById(ownerId).orElse(null);
	}
	
	@InitBinder("owner")
	public void initOwnerBinder(WebDataBinder binder){
		binder.setDisallowedFields("id");
	}

}
