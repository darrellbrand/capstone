package com.example.demo.service;

import com.example.demo.domain.GuitarPart;
import com.example.demo.repositories.GuitarPartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */

@Service
public class GuitarPartServiceImpl implements GuitarPartService {
        private GuitarPartRepository guitarPartRepository;

        @Autowired

    public GuitarPartServiceImpl(GuitarPartRepository guitarPartRepository) {
        this.guitarPartRepository = guitarPartRepository;
    }

    @Override
    public List<GuitarPart> findAll() {
        return (List<GuitarPart>) guitarPartRepository.findAll();
    }
    public List<GuitarPart> listAll(String keyword){
        if(keyword !=null){
            return guitarPartRepository.search(keyword);
        }
        return (List<GuitarPart>) guitarPartRepository.findAll();
    }
    @Override
    public GuitarPart findById(int theId) {
        Long theIdl=(long)theId;
        Optional<GuitarPart> result = guitarPartRepository.findById(theIdl);

        GuitarPart theGuitarPart = null;

        if (result.isPresent()) {
            theGuitarPart = result.get();
        }
        else {
            // we didn't find the part id
            throw new RuntimeException("Did not find part id - " + theId);
        }

        return theGuitarPart;
    }

    @Override
    public void save(GuitarPart theGuitarPart) {
            guitarPartRepository.save(theGuitarPart);

    }

    @Override
    public void deleteById(int theId) {
        Long theIdl=(long)theId;
        guitarPartRepository.deleteById(theIdl);
    }
}
