package com.example.demo.service;

import com.example.demo.domain.FenderGuitarPart;

import java.util.List;

/**
 *
 *
 *
 *
 */
public interface FenderPartService {
    public List<FenderGuitarPart> findAll();
    public FenderGuitarPart findById(int theId);
    public void save (FenderGuitarPart thePart);
    public void deleteById(int theId);
}
