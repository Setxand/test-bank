package com.banks.repository;

import com.banks.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by TEST on 23.05.2018.
 */
@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount,Long>{

}
