package com.banks.repository;

import com.banks.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by TEST on 23.05.2018.
 */
public interface UserRepository extends JpaRepository<User,Long>{
    User findByLogin(String login);
    @Query(nativeQuery = true,value = "select*from user where name like %?1% or last_name like %?1% or login like %?1%")
    List<User>findByName(String name);
}
