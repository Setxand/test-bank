package com.banks.repository;

import com.banks.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by TEST on 23.05.2018.
 */
@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
}
