package com.htu.petclinichtu.services;

import org.springframework.data.repository.CrudRepository;

import com.htu.petclinichtu.models.Visit;

public interface VisitService extends CrudRepository<Visit, Long> {

}
