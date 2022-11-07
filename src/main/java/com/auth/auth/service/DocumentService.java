package com.auth.auth.service;

import com.auth.auth.entity.Document;

import java.util.List;

public interface DocumentService {
    
    List<Document> getAll();

    Document getById(int id);

    Document save(Document document);

    void delete(int id);


}
