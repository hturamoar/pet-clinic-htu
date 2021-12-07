package com.htu.petclinichtu.services.jpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.htu.petclinichtu.models.PetType;
import com.htu.petclinichtu.repositories.PetTypeRepository;
import com.htu.petclinichtu.services.PetTypeService;

@Service
@Profile("SpringDataJPA")
public class PetTypeServiceJPA implements PetTypeService {
	
	private final PetTypeRepository petTypeRepository;

	public PetTypeServiceJPA(PetTypeRepository petTypeRepository) {
		super();
		this.petTypeRepository = petTypeRepository;
	}

	@Override
	public Set<PetType> findAll() {
		Set<PetType> petTypes = new HashSet<PetType>();
		petTypeRepository.findAll().forEach(petTypes::add);
		return petTypes;
	}

	@Override
	public PetType findById(Long id) {
		return petTypeRepository.findById(id).orElse(null);
	}

	@Override
	public PetType save(PetType t) {
		return petTypeRepository.save(t);
	}

	@Override
	public void delete(PetType t) {
		petTypeRepository.delete(t);
	}

	@Override
	public void deleteById(Long id) {
		petTypeRepository.deleteById(id);
	}

}
