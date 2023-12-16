package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Colis;
import com.example.demo.entity.Location;
import com.example.demo.repository.LocationRepository;

@Service
public class LocationService {

	@Autowired
	private LocationRepository locationRepo;

	public Location save(Location entity) {
		return locationRepo.save(entity);
	}

	public List<Location> findAll() {
		return locationRepo.findAll();
	}

	public Optional<Location> findById(Integer id) {
		return locationRepo.findById(id);
	}

	public void delete(Location entity) {
		locationRepo.delete(entity);
	}
	
	
	
}
