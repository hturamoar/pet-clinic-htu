package com.htu.petclinichtu.services.jpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.htu.petclinichtu.models.Pet;
import com.htu.petclinichtu.repositories.PetRepository;
import com.htu.petclinichtu.services.PetService;

@Service
@Profile("SpringDataJPA")
public class PetServiceJPA implements PetService {
	
	private final PetRepository petRepository;

	public PetServiceJPA(PetRepository petRepository) {
		super();
		this.petRepository = petRepository;
	}

	@Override
	public Set<Pet> findAll() {
		Set<Pet> pets = new HashSet<Pet>();
		petRepository.findAll().forEach(pets::add);
		return pets;
	}

	@Override
	public Pet findById(Long id) {
		return petRepository.findById(id).orElse(null);
	}

	@Override
	public Pet save(Pet t) {
		return petRepository.save(t);
	}

	@Override
	public void delete(Pet t) {
		petRepository.delete(t);
	}

	@Override
	public void deleteById(Long id) {
		petRepository.deleteById(id);
	}

}
