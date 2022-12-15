package com.auth.auth.repository;

import com.auth.auth.ResourceNotFoundException;
import com.auth.auth.entity.Phase;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Phase repository.
 */
@Repository
public interface PhaseRepository extends JpaRepository<Phase, Integer> {
    /**
     * Find by id or throw phase.
     *
     * @param id the id
     * @return the phase
     * @throws ResourceNotFoundException the resource not found exception
     */
    default Phase findByIdOrThrow(int id) throws ResourceNotFoundException {
        return this.findById(id).orElseThrow(
            () -> new ResourceNotFoundException(this.getClass().getName(), "id", id));
        
}
}