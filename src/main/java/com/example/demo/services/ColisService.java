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

	public Colis save(Colis entity) {
		return colisRepo.save(entity);
	}

	public List<Colis> findAll() {
		return colisRepo.findAll();
	}

	public Optional<Colis> findById(Integer id) {
		return colisRepo.findById(id);
	}

	public void delete(Colis entity) {
		colisRepo.delete(entity);
	}

	public Colis updateColisLocations(int colisId, Location newLocation) {
		// Récupérer le colis existant depuis la base de données
		Colis existingColis = colisRepo.findById(colisId)
				.orElseThrow(() -> new RuntimeException("Colis not found with id: " + colisId));

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
