package com.htu.petclinichtu.services.jpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.htu.petclinichtu.models.Vet;
import com.htu.petclinichtu.repositories.VetRepository;
import com.htu.petclinichtu.services.VetService;

@Service
@Profile("SpringDataJPA")
public class VetServiceJPA implements VetService{
	
	private final VetRepository vetRepository;

	public VetServiceJPA(VetRepository vetRepository) {
		super();
		this.vetRepository = vetRepository;
	}

	@Override
	public Set<Vet> findAll() {
		Set<Vet> vets = new HashSet<>();
		vetRepository.findAll().forEach(vets::add);
		return vets;
	}

	@Override
	public Vet findById(Long id) {
		return vetRepository.findById(id).orElse(null);
	}

	@Override
	public Vet save(Vet t) {
		return vetRepository.save(t);
	}

	@Override
	public void delete(Vet t) {
		vetRepository.delete(t);
	}

	@Override
	public void deleteById(Long id) {
		vetRepository.deleteById(id);		
	}
}
