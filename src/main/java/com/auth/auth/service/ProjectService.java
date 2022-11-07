package com.auth.auth.service;

import com.auth.auth.entity.Project;

import java.util.List;

public interface ProjectService {
    
    List<Project> getAll();
    
    Project getById(int id);
    
    Project save(Project project);
    
    void delete(int id);
}