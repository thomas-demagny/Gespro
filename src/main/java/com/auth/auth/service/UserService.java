package com.auth.auth.service;

import java.util.List;


import com.auth.auth.entity.User;

/**
 * The interface User service.
 */
public interface UserService {

    /**
     * Find all list.
     *
     * @return the list
     */
    List<User> findAll();

    /**
     * Find by id user.
     *
     * @param id the id
     * @return the user
     */
    User findById(int id);

    /**
     * Find by username user.
     *
     * @param username the username
     * @return the user
     */
    User findByUsername(String username);

    /**
     * Save user.
     *
     * @param user the user
     * @return the user
     */
    User save(User user);

    /**
     * Delete.
     *
     * @param id the id
     */
    void delete(int id);

    
}