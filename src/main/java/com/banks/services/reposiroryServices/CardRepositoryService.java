package com.banks.services.reposiroryServices;

import com.banks.entities.Card;
import com.banks.entities.Transaction;

import java.util.List;

/**
 * Created by TEST on 24.05.2018.
 */
public interface CardRepositoryService {
    List<Card> findAll();
    Card findOne(Long id);
    Card saveAndFlush(Card card);
    void delete(Card card);
}
