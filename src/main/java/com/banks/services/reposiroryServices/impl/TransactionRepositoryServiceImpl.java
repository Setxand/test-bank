package com.banks.services.reposiroryServices.impl;

import com.banks.entities.Transaction;
import com.banks.repository.TransactionRepository;
import com.banks.services.reposiroryServices.TransactionRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by TEST on 23.05.2018.
 */
@Service
public class TransactionRepositoryServiceImpl implements TransactionRepositoryService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public List<Transaction> findByName(String name) {
        return transactionRepository.findAllByName(name);
    }

    @Override
    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction findOne(Long id) {
        return transactionRepository.getOne(id);
    }

    @Override
    public Transaction saveAndFlush(Transaction transaction) {
        return transactionRepository.saveAndFlush(transaction);
    }

    @Override
    public void delete(Transaction transaction) {
        transactionRepository.delete(transaction);
    }
}
