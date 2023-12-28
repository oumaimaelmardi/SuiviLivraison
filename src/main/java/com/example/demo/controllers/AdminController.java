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

import com.example.demo.entity.Admin;
import com.example.demo.services.AdminService;

@RestController
@RequestMapping("api/controller")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@PostMapping("/")
	public Admin save(@RequestBody Admin entity) {
		return adminService.save(entity);
	}

	@GetMapping("/")
	public List<Admin> findAll() {
		return adminService.findAll();
	}
	

	@GetMapping("/id/{id}")
	public Admin findById(@PathVariable int id) {
		return adminService.findById(id);
	}

	@DeleteMapping("/id/{id}")
	public void delete(@PathVariable int id) {
		adminService.delete(id);
	}

	@PutMapping("/")
	public Admin update(@RequestBody Admin admin) {
		return adminService.update(admin);
	}

	@DeleteMapping("/")
	public void deleteAll() {
		adminService.deleteAll();
	}


	
	
	
}
