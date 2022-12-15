package com.auth.auth.service;

import com.auth.auth.entity.Role;
import com.auth.auth.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Role service.
 */
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    /**
     * Instantiates a new Role service.
     *
     * @param roleRepository the role repository
     */
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
    
