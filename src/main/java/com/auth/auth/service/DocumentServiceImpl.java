package com.auth.auth.service;

import com.auth.auth.entity.Document;
import com.auth.auth.repository.DocumentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService{

    private final DocumentRepository documentRepository;

    public DocumentServiceImpl(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @Override
    public List<Document> getAll() {
        return documentRepository.findAll();
        
    }

        

    @Override
    public Document getById(int id) {
        return documentRepository.findByIdOrThrow(id);
      
    }

    @Override
    public Document save(Document document) {
        return documentRepository.save(document);
        
        
    }

    
    @Override
    public void delete(int id) {
      Document document = documentRepository.findByIdOrThrow(id);
          documentRepository.delete(document);
        
    }
    
}