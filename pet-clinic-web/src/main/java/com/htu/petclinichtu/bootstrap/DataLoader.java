package com.htu.petclinichtu.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.htu.petclinichtu.models.Owner;
import com.htu.petclinichtu.models.Pet;
import com.htu.petclinichtu.models.PetType;
import com.htu.petclinichtu.models.Vet;
import com.htu.petclinichtu.services.OwnerService;
import com.htu.petclinichtu.services.PetTypeService;
import com.htu.petclinichtu.services.VetService;
import com.htu.petclinichtu.services.map.OwnerServiceMap;
import com.htu.petclinichtu.services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;

	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
		super();
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
	}

	@Override
	public void run(String... args) throws Exception {

		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedDogPetType = petTypeService.save(dog);
		
		PetType cat = new PetType();
		cat.setName("Cat");
		PetType savedCatPetType = petTypeService.save(cat);

		Owner owner1 = new Owner();
		owner1.setFirstName("Michael");
		owner1.setLastName("Williams");
		owner1.setAddress("1234");
		owner1.setCity("Blore");
		owner1.setTelephone("+223444545");
		
		Pet mikesPet = new Pet();
		mikesPet.setPetType(savedDogPetType);
		mikesPet.setOwner(owner1);
		mikesPet.setName("Rosco");
		mikesPet.setBirthDate(LocalDate.now());
		owner1.getPets().add(mikesPet);
		
		ownerService.save(owner1);

		Owner owner2 = new Owner();
		owner2.setFirstName("Fioana");
		owner2.setLastName("Gendalle");
		owner2.setAddress("1345");
		owner2.setCity("Cnnai");
		owner2.setTelephone("+22344567545");
		
		Pet GenPet = new Pet();
		GenPet.setPetType(savedCatPetType);
		GenPet.setOwner(owner2);
		GenPet.setName("Kitty");
		GenPet.setBirthDate(LocalDate.now());
		owner2.getPets().add(GenPet);
		ownerService.save(owner2);

		System.out.println("Loading Owners------");

		Vet vet1 = new Vet();
		vet1.setFirstName("Sam");
		vet1.setLastName("Dane");
		vetService.save(vet1);

		Vet vet2 = new Vet();
		vet2.setFirstName("Jessie");
		vet2.setLastName("Axe");
		vetService.save(vet2);

		System.out.println("Loading Vets------");
	}

}
