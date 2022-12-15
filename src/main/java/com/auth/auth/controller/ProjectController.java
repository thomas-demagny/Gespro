package com.auth.auth.controller;

import java.util.List;
import java.util.stream.Collectors;


import com.auth.auth.service.ProjectServiceImpl;
import com.auth.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.auth.auth.entity.Project;
import com.auth.auth.service.ProjectService;

import javax.validation.Valid;

/**
 * The type Project controller.
 */
@RestController
@RequestMapping("project")
public class ProjectController {

  
    @Autowired
    private ProjectService projectService;
    @Autowired
    private ProjectServiceImpl projectServiceImpl;

    /**
     * Gets all.
     *
     * @return the all
     */
    @GetMapping
    public List<Project> getAll() {
        return   projectService.getAll().stream()
                .map(project-> projectService
                .save(project))
                .collect(Collectors.toList());
    }

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    @GetMapping("/{id}")
    public Project getById(@PathVariable(value = "id") int id) {
        return projectService.getById(id);
    }

    /**
     * Create response entity.
     *
     * @param project the project
     * @return the response entity
     */
    @PostMapping("/new")
    public ResponseEntity<Project> create(@RequestBody Project project) {
        Project response = projectService.save(project);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /**
     * Update response entity.
     *
     * @param project the project
     * @return the response entity
     */
    @PutMapping("/{id}")
    public ResponseEntity<Project> update(@Valid @RequestBody Project project) {

        Project response = projectService.save(project);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Delete response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Project> delete(@PathVariable(value = "id") int id) {
        projectService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}