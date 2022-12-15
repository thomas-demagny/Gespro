package com.auth.auth.service;

import com.auth.auth.entity.Document;
import com.auth.auth.repository.DocumentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Document service.
 */
@Service
public class DocumentServiceImpl implements DocumentService{

    private final DocumentRepository documentRepository;

    /**
     * Instantiates a new Document service.
     *
     * @param documentRepository the document repository
     */
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