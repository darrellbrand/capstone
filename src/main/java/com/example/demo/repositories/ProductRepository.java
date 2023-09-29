package com.example.demo.repositories;

import com.example.demo.domain.Guitar;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 *
 *
 *
 *
 */
public interface ProductRepository extends CrudRepository<Guitar,Long> {
    @Query("SELECT p FROM Guitar p WHERE p.name LIKE %?1%")
    public List<Guitar> search(String keyword);
}
