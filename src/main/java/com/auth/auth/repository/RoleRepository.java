package com.auth.auth.repository;

import java.util.Optional;

import com.auth.auth.ResourceNotFoundException;
import com.auth.auth.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import com.auth.auth.entity.Erole;
import com.auth.auth.entity.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    default Role findByIdOrThrow(int id) throws ResourceNotFoundException{
        return this.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(this.getClass().getName(), "id", id));

}

    Optional<Role> findById(int id);

    Optional<Role> findByName(Erole name);

}
