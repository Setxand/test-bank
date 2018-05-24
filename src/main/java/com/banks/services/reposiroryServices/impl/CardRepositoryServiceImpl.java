package com.banks.services.reposiroryServices.impl;

import com.banks.entities.Card;
import com.banks.entities.Transaction;
import com.banks.repository.CardRepository;
import com.banks.services.reposiroryServices.CardRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by TEST on 24.05.2018.
 */
@Service
public class CardRepositoryServiceImpl implements CardRepositoryService {
    @Autowired
    private CardRepository cardRepository;


    @Override
    public List<Card> findAll() {
        return cardRepository.findAll();
    }

    @Override
    public Card findOne(Long id) {
        return cardRepository.getOne(id);
    }

    @Override
    public Card saveAndFlush(Card card) {
        return cardRepository.saveAndFlush(card);
    }

    @Override
    public void delete(Card card) {
        cardRepository.delete(card);
    }


}
