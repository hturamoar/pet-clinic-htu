package com.htu.petclinichtu.services;

import com.htu.petclinichtu.models.Owner;

public interface OwnerService extends CrudService<Owner, Long>{
	
	Owner findByLastName(String lastName);
}
