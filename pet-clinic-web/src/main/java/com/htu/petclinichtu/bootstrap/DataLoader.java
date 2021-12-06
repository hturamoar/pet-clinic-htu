package com.htu.petclinichtu.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.htu.petclinichtu.models.Owner;
import com.htu.petclinichtu.models.Vet;
import com.htu.petclinichtu.services.OwnerService;
import com.htu.petclinichtu.services.VetService;
import com.htu.petclinichtu.services.map.OwnerServiceMap;
import com.htu.petclinichtu.services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner{
	
	private final OwnerService ownerService;
	private final VetService vetService;
	
	public DataLoader(OwnerService ownerService, VetService vetService) {
		super();
		this.ownerService = ownerService;
		this.vetService = vetService;
	}




	@Override
	public void run(String... args) throws Exception {
		Owner owner1 = new Owner();
		owner1.setFirstName("Michael");
		owner1.setLastName("Williams");
		ownerService.save(owner1);
		
		Owner owner2 = new Owner();
		owner2.setFirstName("Fioana");
		owner2.setLastName("Gendalle");
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
