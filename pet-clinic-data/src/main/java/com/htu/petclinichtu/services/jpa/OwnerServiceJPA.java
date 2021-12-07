package com.htu.petclinichtu.services.jpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.htu.petclinichtu.models.Owner;
import com.htu.petclinichtu.repositories.OwnerRepository;
import com.htu.petclinichtu.repositories.PetRepository;
import com.htu.petclinichtu.repositories.PetTypeRepository;
import com.htu.petclinichtu.services.OwnerService;

@Service
@Profile("SpringDataJPA")
public class OwnerServiceJPA implements OwnerService{
	
	private final OwnerRepository ownerRepository;
	private final PetRepository petRepository;
	private final PetTypeRepository petTypeRepository;

	public OwnerServiceJPA(OwnerRepository ownerRepository, PetRepository petRepository,
			PetTypeRepository petTypeRepository) {
		super();
		this.ownerRepository = ownerRepository;
		this.petRepository = petRepository;
		this.petTypeRepository = petTypeRepository;
	}

	@Override
	public Set<Owner> findAll() {
		Set<Owner> owners = new HashSet<>();
		ownerRepository.findAll().forEach(owners::add);
		return owners;
	}

	@Override
	public Owner findById(Long id) {
			return ownerRepository.findById(id).orElse(null);
	}

	@Override
	public Owner save(Owner t) {
		return ownerRepository.save(t);
	}

	@Override
	public void delete(Owner t) {
		ownerRepository.delete(t);		
	}

	@Override
	public void deleteById(Long id) {
		ownerRepository.deleteById(id);		
	}

	@Override
	public Owner findByLastName(String lastName) {
		return ownerRepository.findByLastName(lastName);
	}
	
}
