package com.auth.auth.service;

import com.auth.auth.entity.Phase;

import java.util.List;

/**
 * The interface Phase service.
 */
public interface PhaseService {

    /**
     * Gets all.
     *
     * @return the all
     */
    List<Phase> getAll();

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    Phase getById(int id);

    /**
     * Save phase.
     *
     * @param phase the phase
     * @return the phase
     */
    Phase save(Phase phase);

    /**
     * Delete.
     *
     * @param id the id
     */
    void delete(int id);
}