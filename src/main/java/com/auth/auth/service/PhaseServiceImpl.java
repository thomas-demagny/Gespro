package com.auth.auth.service;

import com.auth.auth.entity.Phase;
import com.auth.auth.repository.PhaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhaseServiceImpl implements PhaseService {

    private final PhaseRepository phaseRepository;

    public PhaseServiceImpl(PhaseRepository phaseRepository) {
        super();
        this.phaseRepository = phaseRepository;
    }
    @Override
    public List<Phase> getAll() {
return  phaseRepository.findAll();
    }

    @Override
    public Phase getById(int id) {
        return phaseRepository.findByIdOrThrow(id);
    }

    @Override
    public Phase save(Phase phase) {
        return phaseRepository.save(phase);
    }

    @Override
    public void delete(int id) {
        Phase phase = phaseRepository.findByIdOrThrow(id);
        phaseRepository.delete(phase);
        
    }

}