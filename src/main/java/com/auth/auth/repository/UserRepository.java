package com.auth.auth.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auth.auth.ResourceNotFoundException;
import com.auth.auth.entity.User;

/**
 * The interface User repository.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * Find by id or throw user.
     *
     * @param id the id
     * @return the user
     * @throws ResourceNotFoundException the resource not found exception
     */
    default User findByIdOrThrow(int id) throws ResourceNotFoundException{
        return this.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException(this.getClass().getName(), "id", id));

        
}

    /**
     * Find by username user.
     *
     * @param username the username
     * @return the user
     */
    User findByUsername(String username);

    /**
     * Exists by username boolean.
     *
     * @param username the username
     * @return the boolean
     */
    Boolean existsByUsername(String username);

    /**
     * Exists by email boolean.
     *
     * @param email the email
     * @return the boolean
     */
    Boolean existsByEmail(String email);

     
}
    
