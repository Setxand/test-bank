package com.banks.services.reposiroryServices;

import com.banks.entities.Check;

import java.util.List;

/**
 * Created by TEST on 23.05.2018.
 */
public interface CheckRepositoryService {
    List<Check>findAll();
    Check findOne(Long id);
    Check saveAndFlush(Check check);
    void delete(Check check);
}
