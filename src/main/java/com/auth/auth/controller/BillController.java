package com.auth.auth.controller;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.auth.auth.ResourceNotFoundException;
import com.auth.auth.entity.Bill;
import com.auth.auth.service.BillService;




@RestController
@RequestMapping("bill")
public class BillController {

    @Autowired
    public BillService billService;

    @PostMapping("/new")
    public ResponseEntity<Bill> create(@RequestBody Bill bill) {

        Bill response = billService.save(bill);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public List<Bill> getAll() {
        return billService.getAll().stream()
                .map(bill-> billService
                .save(bill))
                .collect(Collectors.toList());

    }

    @GetMapping("/{id}")
    public Bill getBillById(@PathVariable(value = "id") int id) throws ResourceNotFoundException {
        return this.billService.getById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bill> update(@PathVariable(value = "id") int id, @RequestBody Bill bill) throws ResourceNotFoundException {
        Bill response = billService.save(bill);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Bill> deleteBill(@PathVariable(value = "id") int id) {

        billService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);

    }

}