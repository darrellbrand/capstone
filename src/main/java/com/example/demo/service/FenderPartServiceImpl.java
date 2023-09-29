package com.example.demo.service;

import com.example.demo.domain.FenderGuitarPart;
import com.example.demo.repositories.FenderPartRepository;
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
public class FenderPartServiceImpl implements FenderPartService {
    private FenderPartRepository partRepository;

    @Autowired
    public FenderPartServiceImpl(FenderPartRepository partRepository) {
        this.partRepository = partRepository;
    }

    @Override
    public List<FenderGuitarPart> findAll() {
        return (List<FenderGuitarPart>) partRepository.findAll();
    }

    @Override
    public FenderGuitarPart findById(int theId) {
        Long theIdl=(long)theId;
        Optional<FenderGuitarPart> result = partRepository.findById(theIdl);

        FenderGuitarPart thePart = null;

        if (result.isPresent()) {
            thePart = result.get();
        }
        else {
            // we didn't find the InhousePart id
            //throw new RuntimeException("Did not find part id - " + theId);
            return null;
        }

        return thePart;
    }

    @Override
    public void save(FenderGuitarPart thePart) {
        partRepository.save(thePart);

    }

    @Override
    public void deleteById(int theId) {
        Long theIdl=(long)theId;
        partRepository.deleteById(theIdl);
    }

}
