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


/**
 * The type Bill controller.
 */
@RestController
@RequestMapping("bill")
public class BillController {

    /**
     * The Bill service.
     */
    @Autowired
    public BillService billService;

    /**
     * Create response entity.
     *
     * @param bill the bill
     * @return the response entity
     */
    @PostMapping("/new")
    public ResponseEntity<Bill> create(@RequestBody Bill bill) {

        Bill response = billService.save(bill);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Gets all.
     *
     * @return the all
     */
    @GetMapping
    public List<Bill> getAll() {
        return billService.getAll().stream()
                .map(bill-> billService
                .save(bill))
                .collect(Collectors.toList());

    }

    /**
     * Gets bill by id.
     *
     * @param id the id
     * @return the bill by id
     * @throws ResourceNotFoundException the resource not found exception
     */
    @GetMapping("/{id}")
    public Bill getBillById(@PathVariable(value = "id") int id) throws ResourceNotFoundException {
        return this.billService.getById(id);
    }

    /**
     * Update response entity.
     *
     * @param bill the bill
     * @return the response entity
     * @throws ResourceNotFoundException the resource not found exception
     */
    @PutMapping("/{id}")
    public ResponseEntity<Bill> update(@RequestBody Bill bill) throws ResourceNotFoundException {
        Bill response = billService.save(bill);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Delete bill response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Bill> deleteBill(@PathVariable(value = "id") int id) {

        billService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);

    }

}