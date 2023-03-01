package com.auth.auth.repository;

import java.util.Optional;

import com.auth.auth.ResourceNotFoundException;
import com.auth.auth.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

/**
 * The interface Role repository.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    /**
     * Find by id or throw role.
     *
     * @param id the id
     * @return the role
     * @throws ResourceNotFoundException the resource not found exception
     */
    default Role findByIdOrThrow(int id) throws ResourceNotFoundException{
        return this.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(this.getClass().getName(), "id", id));

}

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional
     */
    Optional<Role> findById(int id);

    /**
     * Find by name optional.
     *
     * @param name the name
     * @return the optional
     */
    Optional<Role> findByName(Role.Erole name);



}
