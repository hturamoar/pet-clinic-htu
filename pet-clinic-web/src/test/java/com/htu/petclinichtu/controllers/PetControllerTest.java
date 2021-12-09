package com.htu.petclinichtu.controllers;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.htu.petclinichtu.models.Owner;
import com.htu.petclinichtu.models.Pet;
import com.htu.petclinichtu.models.PetType;
import com.htu.petclinichtu.services.OwnerService;
import com.htu.petclinichtu.services.PetService;
import com.htu.petclinichtu.services.PetTypeService;

@ExtendWith(MockitoExtension.class)
class PetControllerTest {
	@Mock
	PetService petService;
	@Mock
	OwnerService ownerService;
	@Mock
	PetTypeService petTypeService;
	@InjectMocks
	PetController petController;
	
	MockMvc mockMvc;
	Owner owner;
	Set<PetType> petTypes;

	@BeforeEach
	void setUp() throws Exception {
		owner = new Owner();
		owner.setId(1L);
		petTypes = new HashSet<PetType>();
		PetType cat = new PetType();
		cat.setId(1L);
		cat.setName("Cat");
		PetType dog = new PetType();
		dog.setId(2L);
		dog.setName("Dog");
		petTypes.add(cat);
		petTypes.add(dog);
		
		mockMvc = MockMvcBuilders.standaloneSetup(petController).build();
	}

	@Test
	void testInitCreationForm() throws Exception {
		when(ownerService.findById(anyLong())).thenReturn(owner);
		when(petTypeService.findAll()).thenReturn(petTypes);
		
		mockMvc.perform(get("/owners/1/pets/new"))
		.andExpect(status().isOk())
		.andExpect(model().attributeExists("owner"))
		.andExpect(model().attributeExists("pet"))
		.andExpect(view().name("pets/createOrUpdatePetForm"));
	}
	
	@Test
	void testProcessCreationForm() throws Exception {
		when(ownerService.findById(anyLong())).thenReturn(owner);
		when(petTypeService.findAll()).thenReturn(petTypes);
		
		mockMvc.perform(post("/owners/1/pets/new"))
		.andExpect(status().is3xxRedirection())
		.andExpect(view().name("redirect:/owners/1"));
		
		verify(petService).save(any());
	}
	
	@Test
	void testInitUpdateForm() throws Exception {
		when(ownerService.findById(anyLong())).thenReturn(owner);
		when(petTypeService.findAll()).thenReturn(petTypes);
		Pet pet = new Pet();
		pet.setId(2L);
		when(petService.findById(anyLong())).thenReturn(pet);
		
		mockMvc.perform(get("/owners/1/pets/2/edit"))
		.andExpect(status().isOk())
		.andExpect(model().attributeExists("owner"))
		.andExpect(model().attributeExists("pet"))
		.andExpect(view().name("pets/createOrUpdatePetForm"));
		
	}
	
	@Test
	void testProcessUpdateForm() throws Exception {
		when(ownerService.findById(anyLong())).thenReturn(owner);
		when(petTypeService.findAll()).thenReturn(petTypes);
		Pet pet = new Pet();
		pet.setId(2L);
		//when(petService.findById(anyLong())).thenReturn(pet);
		mockMvc.perform(post("/owners/1/pets/2/edit"))
		.andExpect(status().is3xxRedirection())
		.andExpect(view().name("redirect:/owners/1"));
		
		verify(petService).save(any());
	}

}
