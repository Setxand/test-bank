package com.banks.services.reposiroryServices;

import com.banks.entities.Transaction;

import java.util.List;

/**
 * Created by TEST on 23.05.2018.
 */
public interface TransactionRepositoryService {
    List<Transaction>findByName(String name);
    List<Transaction> findAll();
    Transaction findOne(Long id);
    Transaction saveAndFlush(Transaction transaction);
    void delete(Transaction transaction);

}
