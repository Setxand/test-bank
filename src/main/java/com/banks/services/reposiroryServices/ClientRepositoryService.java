package com.banks.services.reposiroryServices;

import com.banks.entities.Client;

import java.util.List;

/**
 * Created by TEST on 23.05.2018.
 */
public interface ClientRepositoryService {
    List<Client> findAll();
    Client findOne(Long id);
    Client saveAndFlush(Client client);
    void delete(Client client);
}
