package com.auth.auth.controller;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.auth.auth.entity.Document;
import com.auth.auth.service.DocumentService;


@RestController
@RequestMapping("document")
public class DocumentController {
    
    @Autowired
    private DocumentService documentService;
    
      
    @GetMapping
    public List<Document> getAll() {
        return documentService.getAll().stream()
                .map(document-> documentService
                .save(document))
                .collect(Collectors.toList());
    }
    
    @GetMapping("/{id}")
    public Document getById(@PathVariable(value = "id") int id) {
        return this.documentService.getById(id);
    }
    
    @PostMapping("/new")
    public Document create(@RequestBody Document document) {
        return documentService.save(document);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Document> update(@PathVariable(value = "id") int id, @RequestBody Document document) {
        Document response = documentService.save(document);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Document> delete(@PathVariable(value = "id") int id) {
        
        documentService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}