package com.example.demo.service;

import com.example.demo.domain.Guitar;

import java.util.List;

/**
 *
 *
 *
 *
 */
public interface GuitarService {
    public List<Guitar> findAll();
    public Guitar findById(int theId);
    public void save (Guitar theGuitar);
    public void deleteById(int theId);
    public List<Guitar> listAll(String keyword);

}
