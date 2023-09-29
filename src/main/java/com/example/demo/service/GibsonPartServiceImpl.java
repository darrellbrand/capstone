package com.example.demo.service;

import com.example.demo.domain.GibsonGuitarPart;
import com.example.demo.repositories.GibsonPartRepository;
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
public class GibsonPartServiceImpl implements GibsonPartService {
    private GibsonPartRepository partRepository;

    @Autowired
    public GibsonPartServiceImpl(GibsonPartRepository partRepository) {
        this.partRepository = partRepository;
    }

    @Override
    public List<GibsonGuitarPart> findAll() {
        return (List<GibsonGuitarPart>) partRepository.findAll();
    }

    @Override
    public GibsonGuitarPart findById(int theId) {
        Long theIdl=(long)theId;
        Optional<GibsonGuitarPart> result = partRepository.findById(theIdl);

        GibsonGuitarPart thePart = null;

        if (result.isPresent()) {
            thePart = result.get();
        }
        else {
            // we didn't find the OutSourced id
            //throw new RuntimeException("Did not find part id - " + theId);
            return null;
        }

        return thePart;
    }

    @Override
    public void save(GibsonGuitarPart thePart) {
        partRepository.save(thePart);

    }

    @Override
    public void deleteById(int theId) {
        Long theIdl=(long)theId;
        partRepository.deleteById(theIdl);
    }

}
