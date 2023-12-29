package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Colis;

@Repository
public interface ColisRepository extends JpaRepository<Colis, Integer>{
	
	Colis findByTrackingNumber(String trackingNumber);

	Colis findById(int id);
	
	Colis save(Colis colis);
	
	
	
	
}
