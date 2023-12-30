package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Colis;
import com.example.demo.entity.Location;
import com.example.demo.repository.ColisRepository;
import com.example.demo.repository.LocationRepository;

@Service
public class ColisService {

	@Autowired
	private ColisRepository colisRepo;
	@Autowired
	private LocationRepository locaRepo;

	public Colis findById(int id) {
		return colisRepo.findById(id);
	}

	public Colis save(Colis colis) {

		List<Location> exColis = colis.getCurrentLocations();

		colisRepo.save(colis);
		for (Location l : exColis) {
			l.setColis(colis);
			locaRepo.save(l);
		}

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

		// Ajouter les nouvelles locations à la liste
		List<Location> newList = new ArrayList<>();

		for (Location i : existingColis.getCurrentLocations()) {
			newList.add(i);

		}
		newList.add(newLocation);

		existingColis.setCurrentLocations(newList);
		newLocation.setColis(existingColis);
		locaRepo.save(newLocation);

		existingColis.setStatus(existingColis.getDestination().equals(newLocation.getCity()));

		// Enregistrer les modifications dans la base de données
		return colisRepo.save(existingColis);
	}

	public Colis findByTrackingNumber(String nbr) {
		return colisRepo.findByTrackingNumber(nbr);

	}

	public List<Colis> findByUserId(int id) {
		return colisRepo.findByUserId(id);
	}
}
