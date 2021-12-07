package com.htu.petclinichtu.services.map;

import java.util.Set;

import com.htu.petclinichtu.models.Visit;
import com.htu.petclinichtu.services.VisitService;

public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService{

	@Override
	public Set<Visit> findAll() {
		return super.findAll();
	}

	@Override
	public Visit findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Visit save(Visit t) {
		if(t.getPet() == null || t.getPet().getOwner() == null || t.getPet().getId()==null ||t.getPet().getOwner().getId() == null) {
			throw new RuntimeException("Invalid Visit");
		}
		return super.save(t);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(Visit t) {
		super.delete(t);
	}

}
