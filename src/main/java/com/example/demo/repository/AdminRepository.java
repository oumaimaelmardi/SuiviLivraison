package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Colis;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{

	Admin findById(int id);
	
	void delete(int id);
	
	Admin save(Admin admin);
	
	Admin update(Admin admin);
}
