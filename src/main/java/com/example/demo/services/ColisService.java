package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Colis;
import com.example.demo.entity.Location;
import com.example.demo.repository.ColisRepository;

@Service
public class ColisService {

	@Autowired
	private ColisRepository colisRepo;

	public Colis findById(int id) {
		return colisRepo.findById(id);
	}

	public Colis save(Colis colis) {
		return colisRepo.save(colis);
	}

	public Colis update(Colis colis) {
		return colisRepo.save(colis);
	}

	public List<Colis> findAll() {
		return colisRepo.findAll();
	}

	public void deleteById(Integer id) {
		colisRepo.deleteById(id);
	}

	public void deleteAll() {
		colisRepo.deleteAll();
	}


	public Colis updateColisLocations(int colisId, Location newLocation) {
		// Récupérer le colis existant depuis la base de données
		
        Colis existingColis = colisRepo.findById(colisId);
             System.out.println("Colis not found with id: " + colisId);

		// Ajouter les nouvelles locations à la liste
		List<Location> newList = new ArrayList<>();

		for (Location i : existingColis.getCurrentLocations()) {
			newList.add(i);

		}
		newList.add(newLocation);

		existingColis.setCurrentLocations(newList);
		if (existingColis.getDestination() == newLocation.getCity()) {
			existingColis.setStatus("votre colis est arrivé");

		} else {
			existingColis.setStatus("votre colis est en cours");

		}

		// Enregistrer les modifications dans la base de données
		return colisRepo.save(existingColis);
	}

	public Colis findByTrackingNumber(String nbr) {
		return colisRepo.findByTrackingNumber(nbr);

	}


	
	
	

}
