package com.banks.repository;

import com.banks.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by TEST on 23.05.2018.
 */
public interface ClientRepository extends JpaRepository<Client,Long> {
}
