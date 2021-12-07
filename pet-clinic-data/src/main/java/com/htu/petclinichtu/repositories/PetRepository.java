package com.htu.petclinichtu.repositories;

import org.springframework.data.repository.CrudRepository;

import com.htu.petclinichtu.models.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
