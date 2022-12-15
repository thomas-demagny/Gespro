package com.auth.auth.service;

import com.auth.auth.entity.Bill;

import java.util.List;

/**
 * The interface Bill service.
 */
public interface BillService {

    /**
     * Gets all.
     *
     * @return the all
     */
    List<Bill> getAll();

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    Bill getById(int id);

    /**
     * Save bill.
     *
     * @param bill the bill
     * @return the bill
     */
    Bill save(Bill bill);

    /**
     * Delete.
     *
     * @param id the id
     */
    void delete(int id);

    

}
