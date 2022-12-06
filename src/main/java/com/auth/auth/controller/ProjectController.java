package com.auth.auth.controller;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.auth.auth.entity.Project;
import com.auth.auth.service.ProjectService;

@RestController
@RequestMapping("project")
public class ProjectController {

  
    @Autowired
    private ProjectService projectService;

    @GetMapping
    public List<Project> getAll() {
        return   projectService.getAll().stream()
                .map(project-> projectService
                .save(project))
                .collect(Collectors.toList());

    }

    @GetMapping("/{id}")
    public Project getById(@PathVariable(value = "id") int id) {
        return projectService.getById(id);
    }

    @PostMapping("/new")
    public ResponseEntity<Project> create(@RequestBody Project project) {
        Project response = projectService.save(project);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> update(@PathVariable(value = "id") int id, @RequestBody Project project) {
        Project response = projectService.save(project);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Project> delete(@PathVariable(value = "id") int id) {
        projectService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}