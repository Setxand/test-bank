package com.banks.repository;

import com.banks.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by TEST on 23.05.2018.
 */
public interface TransactionRepository extends JpaRepository<Transaction,Long> {
    @Query(nativeQuery = true, value = "select*from transaction where sender like %?1% or receiver like %?1% or date like %?1%")
    List<Transaction>findAllByName(String name);
}
