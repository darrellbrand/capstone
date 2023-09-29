package com.example.demo.repositories;

import com.example.demo.domain.GuitarPart;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 *
 *
 *
 *
 */
public interface GuitarPartRepository extends CrudRepository <GuitarPart,Long> {
    @Query("SELECT p FROM GuitarPart p WHERE p.name LIKE %?1%")
    public List<GuitarPart> search(String keyword);
}
