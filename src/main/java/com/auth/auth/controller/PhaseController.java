package com.auth.auth.controller;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.auth.auth.entity.Phase;
import com.auth.auth.service.PhaseService;


/**
 * The type Phase controller.
 */
@RestController
@RequestMapping("phase")
public class PhaseController {

    @Autowired
    private PhaseService phaseService;

    /**
     * Gets all.
     *
     * @return the all
     */
    @GetMapping
    public List<Phase> getAll() {
        return phaseService.getAll().stream()
                .map(phase-> phaseService
                .save(phase))
                .collect(Collectors.toList());

    }

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    @GetMapping("/{id}")
    public Phase getById(@PathVariable(value = "id") int id) {
        return this.phaseService.getById(id);
    }

    /**
     * Create phase.
     *
     * @param phase the phase
     * @return the phase
     */
    @PostMapping("/new")
    public Phase create(@RequestBody Phase phase) {
        return phaseService.save(phase);
    }

    /**
     * Update response entity.
     *
     * @param phase the phase
     * @return the response entity
     */
    @PutMapping("/{id}")
    public ResponseEntity<Phase> update(@RequestBody Phase phase) {
        Phase response = phaseService.save(phase);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Delete response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Phase> delete(@PathVariable(value = "id") int id) {
        phaseService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}