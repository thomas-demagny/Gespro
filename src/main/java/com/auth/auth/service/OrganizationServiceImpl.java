package com.auth.auth.service;

import com.auth.auth.entity.Organization;
import com.auth.auth.repository.OrganizationRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository organizationRepository;

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
    

