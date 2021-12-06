package com.htu.petclinichtu.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.htu.petclinichtu.models.PetType;
import com.htu.petclinichtu.services.PetTypeService;

@Service
public class PetTypeServiceMap extends AbstractMapService<PetType, Long> implements PetTypeService{

	@Override
	public Set<PetType> findAll() {
		return super.findAll();
	}

	@Override
	public PetType findById(Long id) {
		return super.findById(id);
	}

	@Override
	public PetType save(PetType t) {
		return super.save(t);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(PetType t) {
		super.delete(t);
	}
	
}
