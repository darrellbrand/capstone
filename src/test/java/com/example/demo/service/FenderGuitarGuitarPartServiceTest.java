package com.example.demo.service;

import com.example.demo.domain.FenderGuitarPart;
import com.example.demo.repositories.FenderPartRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Project: demo
 * Package: com.example.demo.service
 * <p>
 * User: carolyn.sher
 * Date: 5/3/2022
 * Time: 11:36 AM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
class FenderGuitarGuitarPartServiceTest {
    FenderPartRepository fenderPartRepository;
    FenderPartService fenderPartService;
    @BeforeEach
    void setUp() {
        fenderPartRepository =mock(FenderPartRepository.class);
        fenderPartService =new FenderPartServiceImpl(fenderPartRepository);
    }

    @Test
    void findAll() {
        FenderGuitarPart part=new FenderGuitarPart();
        List partData=new ArrayList();
        partData.add(part);
        when(fenderPartRepository.findAll()).thenReturn(partData);
        List<FenderGuitarPart> parts= fenderPartService.findAll();
        assertEquals(partData.size(),1);
    }
}