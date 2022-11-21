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




@RestController
@RequestMapping("role")
public class RoleController {

    @Autowired
    public RoleService roleService;

    @PostMapping("/new")
    public ResponseEntity<Role> create(@RequestBody Role role) {

        Role response = roleService.save(role);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public List<Role> getAll() {
        return roleService.getAll().stream()
                .map(role-> roleService
                .save(role))
                .collect(Collectors.toList());

    }

    @GetMapping("/{id}")
    public Role getRoleById(@PathVariable(value = "id") int id) throws ResourceNotFoundException {
        return this.roleService.getById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Role> update(@PathVariable(value = "id") int id, @RequestBody Role role) throws ResourceNotFoundException {
        Role response = roleService.save(role);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Role> deleteRole(@PathVariable(value = "id") int id) {

        roleService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);

    }

}