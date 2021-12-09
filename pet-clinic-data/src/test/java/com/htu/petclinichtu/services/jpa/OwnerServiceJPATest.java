package com.htu.petclinichtu.services.jpa;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.htu.petclinichtu.models.Owner;
import com.htu.petclinichtu.repositories.OwnerRepository;
import com.htu.petclinichtu.repositories.PetRepository;
import com.htu.petclinichtu.repositories.PetTypeRepository;

@ExtendWith(MockitoExtension.class)
class OwnerServiceJPATest {
	private static final String lastName = "Smith";
	@Mock
	OwnerRepository ownerRepository;
	@Mock
	PetRepository petRepository;
	@Mock
	PetTypeRepository petTypeRepository;
	
	@InjectMocks
	OwnerServiceJPA service;

	Owner returnOwner;
	@BeforeEach
	void setUp() throws Exception {
		returnOwner = new Owner();
		returnOwner.setId(1L);
	}

	@Test
	void testFindAll() {
		Set<Owner> owners = new HashSet<Owner>();
		Owner owner1 = new Owner();
		owner1.setId(1L);
		Owner owner2 = new Owner();
		owner1.setId(2L);
		owners.add(owner1);
		owners.add(owner2);
		
		when(ownerRepository.findAll()).thenReturn(owners);
		Set<Owner> outOwners = service.findAll();
		assertNotNull(outOwners);
		assertEquals(2, outOwners.size());
	}

	@Test
	void testFindById() {
		when(ownerRepository.findById(org.mockito.ArgumentMatchers.anyLong())).thenReturn(Optional.of(returnOwner));
		Owner owner = service.findById(1L);
		assertNotNull(owner);
	}

	@Test
	void testSave() {
		Owner ownerToSave = new Owner();
		ownerToSave.setId(1L);
		when(ownerRepository.save(org.mockito.ArgumentMatchers.any())).thenReturn(returnOwner);
		Owner savedOwner = service.save(ownerToSave);
		assertNotNull(savedOwner);
		assertEquals(1L, savedOwner.getId());
	}

	@Test
	void testDelete() {
		service.delete(returnOwner);
		assertEquals(0, service.findAll().size());
	}

	@Test
	void testDeleteById() {
		service.deleteById(returnOwner.getId());
		assertEquals(0, service.findAll().size());
	}

	@Test
	void testFindByLastName() {
		Owner result = new Owner();
		result.setId(1L);
		result.setLastName(lastName);
		
		when(ownerRepository.findByLastName(org.mockito.ArgumentMatchers.any())).thenReturn(result);
		Owner owner = service.findByLastName(lastName);
		assertEquals(lastName, owner.getLastName());
		verify(ownerRepository).findByLastName(org.mockito.ArgumentMatchers.any());
	}

}
