package com.banks.services.reposiroryServices.impl;

import com.banks.entities.Check;
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
    public List<Check> findAll() {
        return checkRepository.findAll();
    }

    @Override
    public Check findOne(Long id) {
        return checkRepository.getOne(id);
    }

    @Override
    public Check saveAndFlush(Check check) {
        return checkRepository.saveAndFlush(check);
    }

    @Override
    public void delete(Check check) {
        checkRepository.delete(check);
    }
}
