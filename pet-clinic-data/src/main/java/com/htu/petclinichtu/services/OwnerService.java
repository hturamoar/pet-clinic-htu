package com.htu.petclinichtu.services;

import java.util.List;

import com.htu.petclinichtu.models.Owner;

public interface OwnerService extends CrudService<Owner, Long>{
	
	Owner findByLastName(String lastName);
	List<Owner> findByLastNameLike(String lastName);
}
