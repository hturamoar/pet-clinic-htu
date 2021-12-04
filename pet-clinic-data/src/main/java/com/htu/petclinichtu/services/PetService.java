package com.htu.petclinichtu.services;

import java.util.Set;

import com.htu.petclinichtu.models.Pet;

public interface PetService {
	
	Pet findById(Long id);
	Pet save(Pet pet);
	Set<Pet> findAll();

}
