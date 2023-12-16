package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Colis;
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
		return colisRepo.update(colis);
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

	
	
	
}
