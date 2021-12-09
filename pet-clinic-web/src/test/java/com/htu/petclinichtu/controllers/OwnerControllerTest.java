package com.htu.petclinichtu.controllers;

import static org.hamcrest.CoreMatchers.isA;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hamcrest.Matcher;
import org.hamcrest.core.IsNot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.htu.petclinichtu.models.Owner;
import com.htu.petclinichtu.services.OwnerService;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {
	
	@Mock
	OwnerService ownerService;
	@InjectMocks
	OwnerController ownerController;
	
	Set<Owner> owners;
	
	MockMvc mockMvc;

	@BeforeEach
	void setUp() throws Exception {
		owners = new HashSet<Owner>();
		Owner owner1 = new Owner();
		owner1.setId(1L);
		Owner owner2 = new Owner();
		owner2.setId(2L);
		owners.add(owner1);
		owners.add(owner2);
		
		mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();
	}

//	@Test
//	void testListOwners() throws Exception{
//		
//		when(ownerService.findAll()).thenReturn(owners);
//		mockMvc
//		.perform(get("/owners"))
//		.andExpect(status()
//				   .isOk())
//		.andExpect(view()
//				   .name("owners/index"))
//		.andExpect(model().attribute("owners", owners));
//		
//	}
	

//	@Test
//	void testListOwnersByIndex() throws Exception{
//		
//		when(ownerService.findAll()).thenReturn(owners);
//		mockMvc
//		.perform(get("/owners/index"))
//		.andExpect(status()
//				   .isOk())
//		.andExpect(view()
//				   .name("owners/index"))
//		.andExpect(model().attribute("owners", owners));
//		
//	}

	@Test
	void testFindOwners() throws Exception{
		mockMvc
		.perform(get("/owners/find"))
		.andExpect(status()
				   .isOk())
		.andExpect(view()
				   .name("owners/findOwners"))
		.andExpect(model().attributeExists("owner"));
		verifyNoInteractions(ownerService);
	}
	
	@Test
	void testFindFormReturnManyOwners() throws Exception{
		Owner owner1 = new Owner();
		owner1.setId(1L);
		Owner owner2 = new Owner();
		owner2.setId(2L);
		List<Owner> ownerList = new ArrayList<>();
		ownerList.add(owner1);
		ownerList.add(owner2);
		when(ownerService.findByLastNameLike(anyString())).thenReturn(ownerList);
		
		mockMvc
		.perform(get("/owners"))
		.andExpect(status()
				   .isOk())
		.andExpect(view()
				   .name("owners/ownersList"))
		.andExpect(model().attribute("listOwners",isA(List.class)));
	}
	
	@Test
	void testFindFormReturnOneOwner() throws Exception{
		Owner owner1 = new Owner();
		owner1.setId(1L);
		when(ownerService.findByLastNameLike(anyString())).thenReturn(Arrays.asList(owner1));
		
		mockMvc
		.perform(get("/owners"))
		.andExpect(status()
				   .is3xxRedirection())
		.andExpect(view()
				   .name("redirect:/owners/1"));
	}
	@Test
	void testDisplayOwnersByIndex() throws Exception{
		
		when(ownerService.findById(org.mockito.ArgumentMatchers.anyLong())).thenReturn(owners.iterator().next());
		mockMvc
		.perform(get("/owners/123"))
		.andExpect(status()
				   .isOk())
		.andExpect(view()
				   .name("/owners/ownerDetails"))
		.andExpect(model().attribute("owner", isA(Owner.class) ));
		
	}

}
