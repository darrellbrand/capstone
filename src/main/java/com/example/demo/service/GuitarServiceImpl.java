package com.example.demo.service;

import com.example.demo.domain.Guitar;
import com.example.demo.repositories.ProductRepository;
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
public class GuitarServiceImpl implements GuitarService {
    private ProductRepository productRepository;

    @Autowired

    public GuitarServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Guitar> findAll() {
        return (List<Guitar>) productRepository.findAll();
    }

    @Override
    public Guitar findById(int theId) {
        Long theIdl=(long)theId;
        Optional<Guitar> result = productRepository.findById(theIdl);

        Guitar theGuitar = null;

        if (result.isPresent()) {
            theGuitar = result.get();
        }
        else {
            // we didn't find the product id
            throw new RuntimeException("Did not find part id - " + theId);
        }

        return theGuitar;
    }

    @Override
    public void save(Guitar theGuitar) {
        productRepository.save(theGuitar);

    }

    @Override
    public void deleteById(int theId) {
        Long theIdl=(long)theId;
        productRepository.deleteById(theIdl);
    }
    public List<Guitar> listAll(String keyword){
        if(keyword !=null){
            return productRepository.search(keyword);
        }
        return (List<Guitar>) productRepository.findAll();
    }
}
