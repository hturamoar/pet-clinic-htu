package com.htu.petclinichtu.services.jpa;

import java.util.Optional;

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
	public <S extends Visit> S save(S entity) {
		return visitRepository.save(entity);
	}

	@Override
	public <S extends Visit> Iterable<S> saveAll(Iterable<S> entities) {	
		return visitRepository.saveAll(entities);
	}

	@Override
	public Optional<Visit> findById(Long id) {
		return visitRepository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return visitRepository.existsById(id);
	}

	@Override
	public Iterable<Visit> findAll() {
		return visitRepository.findAll();
	}

	@Override
	public Iterable<Visit> findAllById(Iterable<Long> ids) {
		return visitRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return visitRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		visitRepository.deleteById(id);
	}

	@Override
	public void delete(Visit entity) {
		visitRepository.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		visitRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends Visit> entities) {
		visitRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		visitRepository.deleteAll();
	}

}
