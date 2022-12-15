package com.auth.auth.service;


import com.auth.auth.entity.Bill;
import com.auth.auth.repository.BillRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Bill service.
 */
@Service
public class BillServiceImpl implements BillService{

    private final BillRepository billRepository;

    /**
     * Instantiates a new Bill service.
     *
     * @param billRepository the bill repository
     */
    public BillServiceImpl(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    @Override
    public List<Bill> getAll() {
        return billRepository.findAll();
    }

    @Override
    public Bill getById(int id) {
        return billRepository.findByIdOrThrow(id);
        
    }

    @Override
    public Bill save(Bill bill) {
        return billRepository.save(bill);
        
    
    }

    @Override
    public void delete(int id) {
        Bill bill = billRepository.findByIdOrThrow(id);
         billRepository.delete(bill);
        
    }

}