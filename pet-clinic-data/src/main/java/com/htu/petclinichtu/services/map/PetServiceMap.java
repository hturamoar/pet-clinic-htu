package com.htu.petclinichtu.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.htu.petclinichtu.models.Pet;
import com.htu.petclinichtu.services.PetService;

@Service
@Profile({"map","default"})
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {

	
	public PetServiceMap() {
		System.out.println("PetServiceMap Constructor");
	}
	@Override
	public Set<Pet> findAll() {
		return super.findAll();
	}

	@Override
	public Pet findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Pet save(Pet t) {
		return super.save(t);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(Pet t) {
		super.delete(t);
	}
}
