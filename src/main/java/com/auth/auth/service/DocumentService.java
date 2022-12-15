package com.auth.auth.service;

import com.auth.auth.entity.Document;

import java.util.List;

/**
 * The interface Document service.
 */
public interface DocumentService {

    /**
     * Gets all.
     *
     * @return the all
     */
    List<Document> getAll();

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    Document getById(int id);

    /**
     * Save document.
     *
     * @param document the document
     * @return the document
     */
    Document save(Document document);

    /**
     * Delete.
     *
     * @param id the id
     */
    void delete(int id);


}
