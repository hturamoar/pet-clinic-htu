package com.htu.petclinichtu.services.map;

import java.util.Set;

import com.htu.petclinichtu.models.Owner;
import com.htu.petclinichtu.services.CrudService;

public abstract class OwnerServiceMap extends AbstractMapService<Owner, Long> implements CrudService<Owner, Long> {

	@Override
	public Set<Owner> findAll() {
		return super.findAll();
	}

	@Override
	public Owner findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Owner save(Owner t) {
		return super.save(t,t.getId());
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(Owner t) {
		super.delete(t);
	}
}
