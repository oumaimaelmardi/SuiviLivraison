package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Colis;
import com.example.demo.entity.Location;
import com.example.demo.services.ColisService;

@RestController
@RequestMapping("api/colis")
@CrossOrigin
public class ColisController {
	@Autowired
	private ColisService colisService;

	@PostMapping("/save")
	public Colis save(@RequestBody Colis entity) {
		return colisService.save(entity);
	}

	@GetMapping("/all")
	public List<Colis> findAll() {
		return colisService.findAll();
	}

	@GetMapping("/id/{id}")
	public Colis findById(@PathVariable Integer id) {
		return colisService.findById(id);
	}

	@DeleteMapping("/id/{id}")
	public void delete(@PathVariable int id) {
		colisService.deleteById(id);
	}

	@PutMapping("/update")
	public Colis update(@RequestBody Colis colis) {
		return colisService.update(colis);
	}

	@DeleteMapping("/")
	public void deleteAll() {
		colisService.deleteAll();
	}

	@PutMapping("/update/{colisId}")
	public Colis updateColisLocations(@PathVariable int colisId, @RequestBody Location newLocation) {
		return colisService.updateColisLocations(colisId, newLocation);
	}
    
	@GetMapping("/findByTrackingNumber/{nbr}")
	public Colis findByTrackingNumber(@PathVariable String nbr) {
		return colisService.findByTrackingNumber(nbr);
	}

	@GetMapping("/findByUserId/{id}")
	public List<Colis> findByUserId(@PathVariable int id) {
		return colisService.findByUserId(id);
	}
}
