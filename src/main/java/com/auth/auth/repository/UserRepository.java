package com.auth.auth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auth.auth.ResourceNotFoundException;
import com.auth.auth.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    default User findByIdOrThrow(int id) throws ResourceNotFoundException{
        return this.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException(this.getClass().getName(), "id", id));
        
}

    User findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

     
}
    
