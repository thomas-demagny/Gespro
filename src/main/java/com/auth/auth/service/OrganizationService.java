package com.auth.auth.service;

import com.auth.auth.entity.Organization;

import java.util.List;

public interface OrganizationService {
    
    List<Organization> getAll();

	Organization getById(int id);

	Organization save(Organization organization);

	void delete(int id);
}
