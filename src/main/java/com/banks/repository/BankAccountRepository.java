package com.banks.repository;

import com.banks.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by TEST on 23.05.2018.
 */
@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount,Long>{

    @Query(value = "select all_amount from amounts where id = " +
            "(select id_bank from client where id = ?)", nativeQuery = true)
    List<Integer> findByIdBankAmount(Long id);

    @Query(value = "select * from bank_account where id = " +
            "(select id_bank from client where id = ?)", nativeQuery = true)
    BankAccount findByIdOneBankAmount(Long id);

    @Query(value = "select sum(all_amount) from amounts where id =" +
            " (select id from bank_account where id =" +
            " (select id_bank from client where id = ?))", nativeQuery = true)
    Integer findBySumAllAccouns(Long id);
}