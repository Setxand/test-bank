package com.banks.services.reposiroryServices.impl;

import com.banks.entities.Client;
import com.banks.repository.ClientRepository;
import com.banks.services.reposiroryServices.ClientRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by TEST on 23.05.2018.
 */
@Service
public class ClientRepositoryServiceImpl implements ClientRepositoryService {
    @Autowired
    private ClientRepository clientRepository;
    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client findOne(Long id) {
        return clientRepository.getOne(id);
    }

    @Override
    public Client saveAndFlush(Client client) {
        return clientRepository.saveAndFlush(client);
    }

    @Override
    public void delete(Client client) {
        clientRepository.delete(client);
    }
}
