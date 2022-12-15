package com.auth.auth.repository;

import com.auth.auth.ResourceNotFoundException;
import com.auth.auth.entity.Document;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Document repository.
 */
@Repository
public interface DocumentRepository extends JpaRepository<Document, Integer> {
    /**
     * Find by id or throw document.
     *
     * @param id the id
     * @return the document
     * @throws ResourceNotFoundException the resource not found exception
     */
    default Document findByIdOrThrow(int id) throws ResourceNotFoundException {
        return this.findById(id).orElseThrow(
            () -> new ResourceNotFoundException(this.getClass().getName(), "id", id));
        
}
}
