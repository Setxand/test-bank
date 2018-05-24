package com.banks.services.reposiroryServices;

import com.banks.entities.User;

import java.util.List;

/**
 * Created by TEST on 23.05.2018.
 */
public interface UserRepositoryService {
    List<User>findAll();
    User findOne(Long id);
    User saveAndFlush(User bankAccount);
    void delete(User bankAccount);
    User findByLogin(String login);
}
