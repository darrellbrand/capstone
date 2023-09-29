package com.example.demo.service;

import com.example.demo.domain.GibsonGuitarPart;

import java.util.List;

/**
 *
 *
 *
 *
 */
public interface GibsonPartService {
        public List<GibsonGuitarPart> findAll();
        public GibsonGuitarPart findById(int theId);
        public void save (GibsonGuitarPart thePart);
        public void deleteById(int theId);
}
