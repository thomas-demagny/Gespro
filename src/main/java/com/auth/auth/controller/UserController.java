package com.auth.auth.controller;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


import com.auth.auth.entity.Erole;
import com.auth.auth.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.auth.auth.ResourceNotFoundException;
import com.auth.auth.entity.User;
import com.auth.auth.service.UserService;

import javax.validation.Valid;


/**
 * The type User controller.
 */
@RestController
@RequestMapping("user")
public class UserController {


	@Autowired
	private UserService userService;


	/**
	 * Create response entity.
	 *
	 * @param user the user
	 * @return the response entity
	 */
	@PostMapping("/new")

	public ResponseEntity<User> create(@RequestBody User user) {

		User response = userService.save(user);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}


	/**
	 * Gets all.
	 *
	 * @return the all
	 */
	@GetMapping
	public List<User> getAll() {
		return userService.findAll().stream()
				.map(user-> userService
				.save(user))
				.collect(Collectors.toList());

	}

	/**
	 * Find user by id user.
	 *
	 * @param id the id
	 * @return the user
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@GetMapping("/{id}")
	public User findUserById(@PathVariable(value = "id") int id) throws ResourceNotFoundException {
		return this.userService.findById(id);
	}


	/**
	 * Update response entity.
	 *
	 * @param user the user
	 * @return the response entity
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@PutMapping("/{id}")
	public ResponseEntity<User> update(@RequestBody User user) throws ResourceNotFoundException {

		User response = userService.save(user);

		return ResponseEntity.ok().body(response);
	}

	/**
	 * Delete employee response entity.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteEmployee(@PathVariable(value = "id") int id) {

		userService.delete(id);

		return new ResponseEntity<>(HttpStatus.OK);

	}
}