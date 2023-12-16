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
	
	
}
