package com.auth.auth.controller;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.auth.auth.ResourceNotFoundException;
import com.auth.auth.entity.Role;
import com.auth.auth.service.RoleService;


/**
 * The type Role controller.
 */
@RestController
@RequestMapping("role")
public class RoleController {

    /**
     * The Role service.
     */
    @Autowired
    public RoleService roleService;

    /**
     * Create response entity.
     *
     * @param role the role
     * @return the response entity
     */
    @PostMapping("/new")
    public ResponseEntity<Role> create(@RequestBody Role role) {

        Role response = roleService.save(role);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Gets all.
     *
     * @return the all
     */
    @GetMapping
    public List<Role> getAll() {
        return roleService.getAll().stream()
                .map(role-> roleService
                .save(role))
                .collect(Collectors.toList());

    }

    /**
     * Gets role by id.
     *
     * @param id the id
     * @return the role by id
     * @throws ResourceNotFoundException the resource not found exception
     */
    @GetMapping("/{id}")
    public Role getRoleById(@PathVariable(value = "id") int id) throws ResourceNotFoundException {
        return this.roleService.getById(id);
    }

    /**
     * Update response entity.
     *
     * @param role the role
     * @return the response entity
     * @throws ResourceNotFoundException the resource not found exception
     */
    @PutMapping("/{id}")
    public ResponseEntity<Role> update(@RequestBody Role role) throws ResourceNotFoundException {
        Role response = roleService.save(role);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Delete role response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Role> deleteRole(@PathVariable(value = "id") int id) {

        roleService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);

    }

}