package com.auth.auth.service;

import com.auth.auth.entity.Role;

import java.util.List;

/**
 * The interface Role service.
 */
public interface RoleService {

    /**
     * Gets all.
     *
     * @return the all
     */
    List<Role> getAll();

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    Role getById(int id);

    /**
     * Save role.
     *
     * @param role the role
     * @return the role
     */
    Role save(Role role);

    /**
     * Delete.
     *
     * @param id the id
     */
    void delete(int id);
    
}