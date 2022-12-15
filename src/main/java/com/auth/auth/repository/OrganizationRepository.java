package com.auth.auth.repository;

import com.auth.auth.ResourceNotFoundException;
import com.auth.auth.entity.Organization;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Organization repository.
 */
@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Integer> {
    /**
     * Find by id or throw organization.
     *
     * @param id the id
     * @return the organization
     * @throws ResourceNotFoundException the resource not found exception
     */
    default Organization findByIdOrThrow(int id) throws ResourceNotFoundException {
        return this.findById(id).orElseThrow(
            () -> new ResourceNotFoundException(this.getClass().getName(), "id", id));
        
}
}


