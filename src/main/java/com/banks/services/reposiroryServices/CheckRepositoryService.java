package com.banks.services.reposiroryServices;

import com.banks.entities.BankAccount;

import java.util.List;

/**
 * Created by TEST on 23.05.2018.
 */
public interface CheckRepositoryService {
    List<BankAccount>findAll();
    BankAccount findOne(Long id);
    BankAccount saveAndFlush(BankAccount bankAccount);
    void delete(BankAccount bankAccount);

}
