package com.auth.auth.controller;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.auth.auth.ResourceNotFoundException;
import com.auth.auth.entity.Organization;
import com.auth.auth.service.OrganizationService;



@RestController
@RequestMapping("organization")
public class OrganizationController {
  

    @Autowired
    public OrganizationService organizationService;

    @PostMapping("/new")
    public ResponseEntity<Organization> create(@RequestBody Organization organization) {
        Organization response = organizationService.save(organization);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    //@PreAuthorize("hasAnyRole('SECRETARY', 'SUPER_ADMIN')")
    @GetMapping
    public List<Organization> getAll() {
        return organizationService.getAll().stream()
                .map(organization-> organizationService
                .save(organization))
                .collect(Collectors.toList());


    }

    @GetMapping("/{id}")
    //@PreAuthorize("hasAnyRole('SECRETARY', 'SUPER_ADMIN')")
    public Organization getOrganizationById(@PathVariable(value = "id") int id) throws ResourceNotFoundException {
        return this.organizationService.getById(id);
    }

    @PutMapping("/{id}")
    //@PreAuthorize("hasAnyRole('SECRETARY', 'SUPER_ADMIN')")
    public ResponseEntity<Organization> update(@PathVariable(value = "id") int id, @RequestBody Organization organization) throws ResourceNotFoundException {
        
        Organization response = organizationService.save(organization);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    //@PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN')")
    public ResponseEntity<Organization> delete(@PathVariable(value = "id") int id) {
        organizationService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}