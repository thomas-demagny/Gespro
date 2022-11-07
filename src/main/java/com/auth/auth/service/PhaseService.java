package com.auth.auth.service;

import com.auth.auth.entity.Phase;

import java.util.List;

public interface PhaseService {
    
    List<Phase> getAll();
    
    Phase getById(int id);
    
    Phase save(Phase phase);
    
    void delete(int id);
}