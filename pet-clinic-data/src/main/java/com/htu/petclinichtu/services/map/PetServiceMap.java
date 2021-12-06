package com.htu.petclinichtu.services.map;

import java.util.Set;

import com.htu.petclinichtu.models.Pet;
import com.htu.petclinichtu.services.CrudService;

public abstract class PetServiceMap extends AbstractMapService<Pet, Long> implements CrudService<Pet, Long> {

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
		return super.save(t,t.getId());
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
