package com.htu.petclinichtu.services.map;

import java.util.Set;
import org.springframework.stereotype.Service;
import com.htu.petclinichtu.models.Owner;
import com.htu.petclinichtu.models.Pet;
import com.htu.petclinichtu.services.OwnerService;
import com.htu.petclinichtu.services.PetService;
import com.htu.petclinichtu.services.PetTypeService;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

	private final PetTypeService petTypeService;
	private final PetService petService;
	
	public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
		super();
		this.petTypeService = petTypeService;
		this.petService = petService;
	}

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
		if(t != null) {
			if (t.getPets() != null) {
				t.getPets().forEach(pet -> {
					if(pet.getPetType() !=null) {
						if(pet.getPetType().getId() == null) {
							pet.setPetType(petTypeService.save(pet.getPetType()));
						}
						
					}else {
						throw new RuntimeException("Pet Type Required");
					}
					if(pet.getId() == null) {
						Pet savedPet = petService.save(pet);
						pet.setId(savedPet.getId());
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
	public void delete(Owner t) {
		super.delete(t);
	}
	
	@Override
	public Owner findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}
}
