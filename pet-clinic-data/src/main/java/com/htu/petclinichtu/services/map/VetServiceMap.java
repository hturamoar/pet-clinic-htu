package com.htu.petclinichtu.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.htu.petclinichtu.models.Vet;
import com.htu.petclinichtu.services.VetService;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

	@Override
	public Set<Vet> findAll() {
		return super.findAll();
	}

	@Override
	public Vet findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Vet save(Vet t) {
		return super.save(t);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(Vet t) {
		super.delete(t);
	}
}
