package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.User;
import com.example.demo.services.UserService;

@RestController
@RequestMapping("api/controller")
@CrossOrigin
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/save")
	public User save(@RequestBody User entity) {
		return userService.save(entity);
	}

	@GetMapping("/all")
	public List<User> findAll() {
		return userService.findAll();
	}
	

	@GetMapping("/id/{id}")
	public User findById(@PathVariable int id) {
		return userService.findById(id);
	}



	@DeleteMapping("/id/{id}")
	public void delete(@PathVariable int id) {
		userService.delete(id);
	}


	@DeleteMapping("/")
	public void deleteAll() {
		userService.deleteAll();
	}


}
