package com.banks.services.reposiroryServices.impl;

import com.banks.entities.BankAccount;
import com.banks.repository.CheckRepository;
import com.banks.services.reposiroryServices.CheckRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by TEST on 23.05.2018.
 */
@Service
public class CheckRepositoryServiceImpl implements CheckRepositoryService {
    @Autowired
    private CheckRepository checkRepository;
    @Override
    public List<BankAccount> findAll() {
        return checkRepository.findAll();
    }

    @Override
    public BankAccount findOne(Long id) {
        return checkRepository.getOne(id);
    }

    @Override
    public BankAccount saveAndFlush(BankAccount bankAccount) {
        return checkRepository.saveAndFlush(bankAccount);
    }

    @Override
    public void delete(BankAccount bankAccount) {
        checkRepository.delete(bankAccount);
    }
}
