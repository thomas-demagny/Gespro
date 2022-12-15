package com.auth.auth.service;

import com.auth.auth.entity.Organization;
import com.auth.auth.repository.OrganizationRepository;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Organization service.
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository organizationRepository;

    /**
     * Instantiates a new Organization service.
     *
     * @param organizationRepository the organization repository
     */
    public OrganizationServiceImpl(OrganizationRepository organizationRepository) {
        super();
        this.organizationRepository = organizationRepository;
    }

    @Override
    public List<Organization> getAll() {
        return organizationRepository.findAll();
    }

    @Override
    public Organization getById(int id) {
        return organizationRepository.findByIdOrThrow(id);
    }

    @Override
    public Organization save(Organization organization) {
        return organizationRepository.save(organization);
    }

    @Override
    public void delete(int id) {
        Organization organization = organizationRepository.findByIdOrThrow(id);
        organizationRepository.delete(organization);
        
    }

   

}
    

