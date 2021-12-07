package com.htu.petclinichtu.services.jpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.htu.petclinichtu.models.Speciality;
import com.htu.petclinichtu.repositories.SpecialityRepository;
import com.htu.petclinichtu.services.SpecialityService;

@Service
@Profile("SpringDataJPA")
public class SpecialityServiceJPA implements SpecialityService {
	
	private final SpecialityRepository specialityRepository;

	public SpecialityServiceJPA(SpecialityRepository specialityRepository) {
		super();
		this.specialityRepository = specialityRepository;
	}

	@Override
	public Set<Speciality> findAll() {
		Set<Speciality> specialities = new HashSet<Speciality>();
		specialityRepository.findAll().forEach(specialities::add);
		return specialities;
	}

	@Override
	public Speciality findById(Long id) {
		return specialityRepository.findById(id).orElse(null);
	}

	@Override
	public Speciality save(Speciality t) {
		return specialityRepository.save(t);
	}

	@Override
	public void delete(Speciality t) {
		specialityRepository.delete(t);
	}

	@Override
	public void deleteById(Long id) {
		specialityRepository.deleteById(id);
	}

}
