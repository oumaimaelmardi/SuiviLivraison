package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.*;
=======
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
>>>>>>> 5e46c57f00d393ab3c394d3c42b1635662df5f5f

import com.example.demo.entity.User;
import com.example.demo.services.UserService;
@CrossOrigin(origins="*")
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
