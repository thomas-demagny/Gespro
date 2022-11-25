/*
package com.auth.auth.controller;

import com.auth.auth.entity.Address;
import com.auth.auth.service.AddressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("address")
public class AddressController {
    

    
    @Autowired
    private AddressService addressService;
    
   

    @GetMapping
    public List<Address> getAllAddresses() {
        return addressService.getAll().stream()
                .map(address-> addressService
                .save(address))
                .collect(Collectors.toList());
     
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable(value = "id") int id) {

        Address address = addressService.getById(id);
        return ResponseEntity.ok().body(address);

        }

    @PostMapping("/new")
    public ResponseEntity<Address> create(@RequestBody Address address) {
        

        Address response = addressService.save(address);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> update(@PathVariable(value = "id") int id, @RequestBody Address address) {

        Address response = addressService.save(address);

        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") int id) {

        addressService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
*/
