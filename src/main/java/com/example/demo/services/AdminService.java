package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Colis;
import com.example.demo.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;

	public Admin findById(int id) {
		return adminRepository.findById(id);
	}

	public void delete(int id) {
		adminRepository.delete(id);
	}

	public Admin save(Admin admin) {
		return adminRepository.save(admin);
	}

	public Admin update(Admin admin) {
		return adminRepository.update(admin);
	}

	public List<Admin> findAll() {
		return adminRepository.findAll();
	}

	public void deleteAll() {
		adminRepository.deleteAll();
	}
	

	
}
