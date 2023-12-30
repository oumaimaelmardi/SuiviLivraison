package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Location;
import com.example.demo.services.LocationService;

@RestController
@RequestMapping("api/location")
@CrossOrigin
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
	public Location findById(@PathVariable int id) {
		return locationService.findById(id);
	}

	

	@PutMapping("/update")
	public Location update(@RequestBody Location location) {
		return locationService.update(location);
	}

	@DeleteMapping("/all")
	public void deleteAll() {
		locationService.deleteAll();
	}

	
	
	
}
