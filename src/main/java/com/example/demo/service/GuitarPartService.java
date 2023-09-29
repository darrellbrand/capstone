package com.example.demo.service;

import com.example.demo.domain.GuitarPart;

import java.util.List;

/**
 *
 *
 *
 *
 */
public interface GuitarPartService {
    public List<GuitarPart> findAll();
    public GuitarPart findById(int theId);
    public void save (GuitarPart theGuitarPart);
    public void deleteById(int theId);

    public List<GuitarPart> listAll(String keyword);
}
