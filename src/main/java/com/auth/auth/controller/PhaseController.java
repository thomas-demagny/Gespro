package com.auth.auth.controller;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.auth.auth.entity.Phase;
import com.auth.auth.service.PhaseService;




@RestController
@RequestMapping("phase")
public class PhaseController {

    @Autowired
    private PhaseService phaseService;

    @GetMapping
    public List<Phase> getAll() {
        return phaseService.getAll().stream()
                .map(phase-> phaseService
                .save(phase))
                .collect(Collectors.toList());

    }

    @GetMapping("/{id}")
    public Phase getById(@PathVariable(value = "id") int id) {
        return this.phaseService.getById(id);
    }

    @PostMapping
    public Phase save(@RequestBody Phase phase) {
        return phaseService.save(phase);
    }
     
    @PutMapping("/{id}")
    public ResponseEntity<Phase> update(@PathVariable(value = "id") int id, @RequestBody Phase phase) {
        Phase response = phaseService.save(phase);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Phase> delete(@PathVariable(value = "id") int id) {
        phaseService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}