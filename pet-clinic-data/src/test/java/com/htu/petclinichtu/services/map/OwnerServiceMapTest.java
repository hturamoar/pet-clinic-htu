package com.htu.petclinichtu.services.map;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.htu.petclinichtu.models.Owner;

class OwnerServiceMapTest {
	
	OwnerServiceMap ownerServiceMap;
	final Long ownerId = 1L;
	final String lastName = "Mark";

	@BeforeEach
	void setUp() throws Exception {
		ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());
		Owner owner = new Owner();
		owner.setId(ownerId);
		owner.setLastName(lastName);
		ownerServiceMap.save(owner);
	}

	@Test
	void testFindAll() {
		
		Set<Owner> ownerSet = ownerServiceMap.findAll();
		assertEquals(1, ownerSet.size());
	}

	@Test
	void testFindByIdLong() {
		Owner owner = ownerServiceMap.findById(ownerId);
		assertEquals(ownerId,owner.getId());
	}

	@Test
	void testSaveOwnerWithID() {
		Long id = 2L;
		Owner owner2 = new Owner();
		owner2.setId(id);
		Owner savedOwner = ownerServiceMap.save(owner2);
		assertEquals(id, savedOwner.getId());
	}
	
	@Test
	void testSaveOwnerWithoutID() {
		Owner savedOwner = ownerServiceMap.save(new Owner());
		assertNotNull(savedOwner);
		assertNotNull(savedOwner.getId());
	}

	@Test
	void testDeleteByIdLong() {
		ownerServiceMap.deleteById(ownerId);
		assertEquals(0, ownerServiceMap.findAll().size());
	}

	@Test
	void testDeleteOwner() {
		ownerServiceMap.delete(ownerServiceMap.findById(ownerId));
		assertEquals(0, ownerServiceMap.findAll().size());
	}

	@Test
	void testFindByLastName() {
		Owner mark = ownerServiceMap.findByLastName(lastName);
		assertNotNull(mark);
		assertEquals(lastName, mark.getLastName());
	}

	@Test
	void testFindByLastNameNotFound() {
		Owner mark = ownerServiceMap.findByLastName(lastName+"HHH");
		assertNull(mark);
	}
}
