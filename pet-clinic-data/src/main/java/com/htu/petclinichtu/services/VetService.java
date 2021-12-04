package com.htu.petclinichtu.services;

import java.util.Set;
import com.htu.petclinichtu.models.Vet;

public interface VetService {
	
	Vet findById(Long id);
	Vet save(Vet vet);
	Set<Vet> findAll();

}
