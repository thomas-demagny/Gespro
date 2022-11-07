package com.auth.auth.repository;

import com.auth.auth.ResourceNotFoundException;
import com.auth.auth.entity.Address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
        default Address findByIdOrThrow(int id) throws ResourceNotFoundException {
                return this.findById(id).orElseThrow(
                    () -> new ResourceNotFoundException(this.getClass().getName(), "id", id));
                
        }
 }

    