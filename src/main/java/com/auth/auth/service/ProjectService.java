package com.auth.auth.service;

import com.auth.auth.entity.Project;

import java.util.List;

/**
 * The interface Project service.
 */
public interface ProjectService {

    /**
     * Gets all.
     *
     * @return the all
     */
    List<Project> getAll();

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    Project getById(int id);

    /**
     * Save project.
     *
     * @param project the project
     * @return the project
     */
    Project save(Project project);

    /**
     * Delete.
     *
     * @param id the id
     */
    void delete(int id);
}