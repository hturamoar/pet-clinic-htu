package com.htu.petclinichtu.services;

import java.util.Set;

import com.htu.petclinichtu.models.Owner;

public interface OwnerService {
	
	Owner findByLastName(String lastName);
	Owner findById(Long id);
	Owner save(Owner owner);
	Set<Owner> findAll();

}
