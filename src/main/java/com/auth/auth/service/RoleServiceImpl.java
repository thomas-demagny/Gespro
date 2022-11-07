package com.auth.auth.service;

import com.auth.auth.entity.Role;
import com.auth.auth.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    
    public RoleServiceImpl(RoleRepository roleRepository) {
        super();
        this.roleRepository = roleRepository;
    }
    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role getById(int id) {
        return roleRepository.findByIdOrThrow(id);
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }
    @Override
    public void delete(int id) {
        Role role = roleRepository.findByIdOrThrow(id);
        roleRepository.delete(role);
        
    }
    
}
    
