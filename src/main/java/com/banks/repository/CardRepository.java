package com.banks.repository;

import com.banks.entities.Card;
import com.banks.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by TEST on 24.05.2018.
 */
public interface CardRepository extends JpaRepository<Card,Long> {

}
