package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Colis;
import com.example.demo.services.ColisService;

@RestController
@RequestMapping("api/controller")
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
public Colis update( @RequestBody Colis colis) {
	return colisService.update(colis);
}

@DeleteMapping("/")
public void deleteAll() {
	colisService.deleteAll();
}


}
