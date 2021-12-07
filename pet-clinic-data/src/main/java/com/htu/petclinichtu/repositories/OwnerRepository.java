package com.htu.petclinichtu.repositories;

import org.springframework.data.repository.CrudRepository;

import com.htu.petclinichtu.models.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
	
	Owner findByLastName(String lastName);

}
