package com.auth.auth.service;

import com.auth.auth.entity.Organization;

import java.util.List;

/**
 * The interface Organization service.
 */
public interface OrganizationService {

    /**
     * Gets all.
     *
     * @return the all
     */
    List<Organization> getAll();

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    Organization getById(int id);

    /**
     * Save organization.
     *
     * @param organization the organization
     * @return the organization
     */
    Organization save(Organization organization);

    /**
     * Delete.
     *
     * @param id the id
     */
    void delete(int id);
}
