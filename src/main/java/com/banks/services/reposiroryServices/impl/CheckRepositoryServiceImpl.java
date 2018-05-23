package com.banks.services.reposiroryServices.impl;

import com.banks.entities.BankAccount;
import com.banks.repository.BankAccountRepository;
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
    private BankAccountRepository bankAccountRepository;
    @Override
    public List<BankAccount> findAll() {
        return bankAccountRepository.findAll();
    }

    @Override
    public BankAccount findOne(Long id) {
        return bankAccountRepository.getOne(id);
    }

    @Override
    public BankAccount saveAndFlush(BankAccount bankAccount) {
        return bankAccountRepository.saveAndFlush(bankAccount);
    }

    @Override
    public void delete(BankAccount bankAccount) {
        bankAccountRepository.delete(bankAccount);
    }
}
