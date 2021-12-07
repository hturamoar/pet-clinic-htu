package com.htu.petclinichtu.services.jpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.htu.petclinichtu.models.Visit;
import com.htu.petclinichtu.repositories.VisitRepository;
import com.htu.petclinichtu.services.VisitService;

@Service
@Profile("SpringDataJPA")
public class VisitServiceJPA implements VisitService {
	
	private final VisitRepository visitRepository;
	
	public VisitServiceJPA(VisitRepository visitRepository) {
		super();
		this.visitRepository = visitRepository;
	}

	@Override
	public Set<Visit> findAll() {
		Set<Visit> visits = new HashSet<Visit>();
		visitRepository.findAll().forEach(visits::add);
		return visits;
	}

	@Override
	public Visit findById(Long id) {
		return visitRepository.findById(id).orElse(null);
	}

	@Override
	public Visit save(Visit t) {
		return visitRepository.save(t);
	}

	@Override
	public void delete(Visit t) {
		visitRepository.delete(t);
	}

	@Override
	public void deleteById(Long id) {
		visitRepository.deleteById(id);
	}

}
