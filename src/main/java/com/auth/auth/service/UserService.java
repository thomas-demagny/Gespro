package com.auth.auth.service;

import java.util.List;


import com.auth.auth.entity.User;

public interface UserService {
    
    List<User> findAll();

    User findById(int id);
    
    User findByUsername(String username);

    User save(User user);

    void delete(int id);
}