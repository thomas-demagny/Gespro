package com.auth.auth.service;

import com.auth.auth.entity.Project;
import com.auth.auth.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Project service.
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    /**
     * Instantiates a new Project service.
     *
     * @param projectRepository the project repository
     */
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        super();
        this.projectRepository = projectRepository;
    }

    @Override
    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project getById(int id) {
        return projectRepository.findByIdOrThrow(id);
    }

    @Override
    public Project save(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public void delete(int id) {
        Project project = projectRepository.findByIdOrThrow(id);
        projectRepository.delete(project);
        
    }

}  
