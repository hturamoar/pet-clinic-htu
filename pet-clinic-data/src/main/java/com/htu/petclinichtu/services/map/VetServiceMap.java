package com.htu.petclinichtu.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.htu.petclinichtu.models.Speciality;
import com.htu.petclinichtu.models.Vet;
import com.htu.petclinichtu.services.SpecialityService;
import com.htu.petclinichtu.services.VetService;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
	
	private final SpecialityService specialityService;

	public VetServiceMap(SpecialityService specialityService) {
		super();
		this.specialityService = specialityService;
	}

	@Override
	public Set<Vet> findAll() {
		return super.findAll();
	}

	@Override
	public Vet findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Vet save(Vet t) {
		if(t != null) {
			if(t.getSpecialities().size() > 0) {
				t.getSpecialities().forEach(speciality -> {
					if(speciality.getId() == null) {
						Speciality savedSpeciality = specialityService.save(speciality);
						speciality.setId(savedSpeciality.getId());
					}
				});
			}
			return super.save(t);
		}else {
			return null;
		}
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(Vet t) {
		super.delete(t);
	}
}
