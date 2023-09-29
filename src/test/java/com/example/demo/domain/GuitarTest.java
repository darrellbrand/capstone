package com.example.demo.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project: demo
 * Package: com.example.demo.domain
 * <p>
 * User: carolyn.sher
 * Date: 4/28/2022
 * Time: 4:01 PM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
class GuitarTest {
    Guitar guitar;
    @BeforeEach
    public void setUp(){
        guitar =new Guitar();
    }
    @Test
    void getId() {
        Long idValue=4L;
        guitar.setId(idValue);
        assertEquals(guitar.getId(), idValue);
    }

    @Test
    void setId() {
        Long idValue=4L;
        guitar.setId(idValue);
        assertEquals(guitar.getId(), idValue);
    }

    @Test
    void getName() {
        String name="test product";
        guitar.setName(name);
        assertEquals(name, guitar.getName());
    }

    @Test
    void setName() {
        String name="test product";
        guitar.setName(name);
        assertEquals(name, guitar.getName());
    }

    @Test
    void getPrice() {
        double price=1.0;
        guitar.setPrice(price);
        assertEquals(price, guitar.getPrice());
    }

    @Test
    void setPrice() {
        double price=1.0;
        guitar.setPrice(price);
        assertEquals(price, guitar.getPrice());
    }

    @Test
    void getInv() {
        int inv=5;
        guitar.setInv(inv);
        assertEquals(inv, guitar.getInv());
    }

    @Test
    void setInv() {
        int inv=5;
        guitar.setInv(inv);
        assertEquals(inv, guitar.getInv());
    }

    @Test
    void getParts() {
        GuitarPart guitarPart1 = new GibsonGuitarPart();
        GuitarPart guitarPart2 = new FenderGuitarPart();
        Set<GuitarPart> myGuitarParts = new HashSet<>();
        myGuitarParts.add(guitarPart1);
        myGuitarParts.add(guitarPart2);
        guitar.setParts(myGuitarParts);
        assertEquals(myGuitarParts, guitar.getParts());
    }

    @Test
    void setParts() {
        GuitarPart guitarPart1 = new GibsonGuitarPart();
        GuitarPart guitarPart2 = new FenderGuitarPart();
        Set<GuitarPart> myGuitarParts = new HashSet<>();
        myGuitarParts.add(guitarPart1);
        myGuitarParts.add(guitarPart2);
        guitar.setParts(myGuitarParts);
        assertEquals(myGuitarParts, guitar.getParts());
    }

    @Test
    void testToString() {
        String name="test product";
        guitar.setName(name);
        assertEquals(name, guitar.toString());
    }

    @Test
    void testEquals() {
        guitar.setId(1l);
        Guitar newGuitar = new Guitar();
        newGuitar.setId(1l);
        assertEquals(guitar, newGuitar);
    }

    @Test
    void testHashCode() {
        guitar.setId(1l);
        Guitar newGuitar = new Guitar();
        newGuitar.setId(1l);
        assertEquals(guitar.hashCode(), newGuitar.hashCode());
    }
}