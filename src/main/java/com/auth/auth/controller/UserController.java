package com.auth.auth.controller;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.auth.auth.ResourceNotFoundException;
import com.auth.auth.entity.User;
import com.auth.auth.service.UserService;


@RestController
@RequestMapping("user")
public class UserController {


	@Autowired
	private UserService userService;


	@PostMapping
	public ResponseEntity<User> save(@RequestBody User user) {

		User response = userService.save(user);

		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@GetMapping
	public List<User> getAll() {
		return userService.findAll().stream()
				.map(user-> userService
				.save(user))
				.collect(Collectors.toList());

	}

	@GetMapping("/{id}")
	public User findUserById(@PathVariable(value = "id") int id) throws ResourceNotFoundException {
		return this.userService.findById(id);
	}


	@PutMapping("/{id}")
	public ResponseEntity<User> update(@PathVariable(value= "id") int id, @RequestBody User user) throws ResourceNotFoundException {


		User response = userService.save(user);

		return ResponseEntity.ok().body(response);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteEmployee(@PathVariable(value = "id") int id) {

		userService.delete(id);

		return new ResponseEntity<>(HttpStatus.OK);

	}
}
