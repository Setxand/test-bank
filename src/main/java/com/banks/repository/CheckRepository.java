package com.banks.repository;

import com.banks.entities.Check;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by TEST on 23.05.2018.
 */
public interface CheckRepository extends JpaRepository<Check,Long>{
}
