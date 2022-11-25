package com.auth.auth.service;

import com.auth.auth.entity.Bill;

import java.util.List;

public interface BillService {

    List<Bill> getAll();

    Bill getById(int id);

    Bill save(Bill bill);

    void delete(int id);

    

}
