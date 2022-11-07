package com.auth.auth.repository;

import com.auth.auth.ResourceNotFoundException;
import com.auth.auth.entity.Bill;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {
    default Bill findByIdOrThrow(int id) throws ResourceNotFoundException {
        return this.findById(id).orElseThrow(
            () -> new ResourceNotFoundException(this.getClass().getName(), "id", id));
        
}
}
