package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Location;
import com.example.demo.services.LocationService;

@RestController
@RequestMapping("api/location")
public class LocationController {

	@Autowired
	private LocationService locationService;

	@PostMapping("/save")
	public Location save(@RequestBody Location entity) {
		return locationService.save(entity);
	}

	@GetMapping("/all")
	public List<Location> findAll() {
		return locationService.findAll();
	}

	@GetMapping("/id/{id}")
	public Optional<Location> findById(@PathVariable Integer id) {
		return locationService.findById(id);
	}

	@DeleteMapping
	public void delete(@RequestBody Location entity) {
		locationService.delete(entity);
	}
	
	
}
