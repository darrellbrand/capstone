package com.example.demo.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Project: demoDarbyFrameworks2-master
 * Package: com.example.demo.domain
 * <p>
 * User: carolyn.sher
 * Date: 6/24/2022
 * Time: 3:45 PM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
class FenderGuitarPartTest {
    FenderGuitarPart ip;
    @BeforeEach
    void setUp() {
        ip= new FenderGuitarPart();
    }
    @Test
    void getCompanyName() {
        String name="fender";
        assertEquals(name,ip.getCompanyName());
    }
}