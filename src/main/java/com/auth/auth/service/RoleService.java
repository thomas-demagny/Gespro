package com.auth.auth.service;

import com.auth.auth.entity.Role;

import java.util.List;

public interface RoleService {

    List<Role> getAll();

     Role getById(int id);

    Role save(Role role);
    
    void delete(int id);
    
}