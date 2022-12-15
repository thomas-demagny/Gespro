package com.auth.auth.repository;

import com.auth.auth.ResourceNotFoundException;
import com.auth.auth.entity.Bill;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Bill repository.
 */
@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {
    /**
     * Find by id or throw bill.
     *
     * @param id the id
     * @return the bill
     * @throws ResourceNotFoundException the resource not found exception
     */
    default Bill findByIdOrThrow(int id) throws ResourceNotFoundException {
        return this.findById(id).orElseThrow(
            () -> new ResourceNotFoundException(this.getClass().getName(), "id", id));
        
}
}
