package com.htu.petclinichtu.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.htu.petclinichtu.models.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
	
	Owner findByLastName(String lastName);
	
	List<Owner> findAllByLastNameLike(String lastName);

}
