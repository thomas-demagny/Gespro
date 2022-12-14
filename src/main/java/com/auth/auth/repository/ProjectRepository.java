package com.auth.auth.repository;

import com.auth.auth.ResourceNotFoundException;
import com.auth.auth.entity.Project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Project repository.
 */
@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

    /**
     * Find by id or throw project.
     *
     * @param id the id
     * @return the project
     * @throws ResourceNotFoundException the resource not found exception
     */
    default Project findByIdOrThrow(int id) throws ResourceNotFoundException {
        return this.findById(id).orElseThrow(
            () -> new ResourceNotFoundException(this.getClass().getName(), "id", id));
        
}
}