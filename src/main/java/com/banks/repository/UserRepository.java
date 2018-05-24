package com.banks.repository;

import com.banks.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by TEST on 23.05.2018.
 */
public interface UserRepository extends JpaRepository<User,Long>{
    User findByLogin(String login);
}
