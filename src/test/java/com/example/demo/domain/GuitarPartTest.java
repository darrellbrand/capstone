package com.example.demo.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Project: demoDarbyFrameworks2-master
 * Package: com.example.demo.domain
 * <p>
 * User: carolyn.sher
 * Date: 6/24/2022
 * Time: 3:44 PM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
class GuitarPartTest {
    GuitarPart guitarPartIn;
    GuitarPart guitarPartOut;
    @BeforeEach
    void setUp() {
        guitarPartIn =new FenderGuitarPart();
        guitarPartOut =new GibsonGuitarPart();
    }
    @Test
    void getId() {
        Long idValue=4L;
        guitarPartIn.setId(idValue);
        assertEquals(guitarPartIn.getId(), idValue);
        guitarPartOut.setId(idValue);
        assertEquals(guitarPartOut.getId(), idValue);
    }

    @Test
    void setId() {
        Long idValue=4L;
        guitarPartIn.setId(idValue);
        assertEquals(guitarPartIn.getId(), idValue);
        guitarPartOut.setId(idValue);
        assertEquals(guitarPartOut.getId(), idValue);
    }

    @Test
    void getName() {
        String name="test inhouse part";
        guitarPartIn.setName(name);
        assertEquals(name, guitarPartIn.getName());
        name="test outsourced part";
        guitarPartOut.setName(name);
        assertEquals(name, guitarPartOut.getName());
    }

    @Test
    void setName() {
        String name="test inhouse part";
        guitarPartIn.setName(name);
        assertEquals(name, guitarPartIn.getName());
        name="test outsourced part";
        guitarPartOut.setName(name);
        assertEquals(name, guitarPartOut.getName());
    }

    @Test
    void getPrice() {
        double price=1.0;
        guitarPartIn.setPrice(price);
        assertEquals(price, guitarPartIn.getPrice());
        guitarPartOut.setPrice(price);
        assertEquals(price, guitarPartOut.getPrice());
    }

    @Test
    void setPrice() {
        double price=1.0;
        guitarPartIn.setPrice(price);
        assertEquals(price, guitarPartIn.getPrice());
        guitarPartOut.setPrice(price);
        assertEquals(price, guitarPartOut.getPrice());
    }

    @Test
    void getInv() {
        int inv=5;
        guitarPartIn.setInv(inv);
        assertEquals(inv, guitarPartIn.getInv());
        guitarPartOut.setInv(inv);
        assertEquals(inv, guitarPartOut.getInv());
    }

    @Test
    void setInv() {
        int inv=5;
        guitarPartIn.setInv(inv);
        assertEquals(inv, guitarPartIn.getInv());
        guitarPartOut.setInv(inv);
        assertEquals(inv, guitarPartOut.getInv());
    }
    @Test
    void getMaxInv() {
        int inv=5;
        guitarPartIn.setMaxInv(inv);
        assertEquals(inv, guitarPartIn.getMaxInv());
        guitarPartOut.setMaxInv(inv);
        assertEquals(inv, guitarPartOut.getMaxInv());
    }

    @Test
    void setMaxInv() {
        int inv=5;
        guitarPartIn.setMaxInv(inv);
        assertEquals(inv, guitarPartIn.getMaxInv());
        guitarPartOut.setMaxInv(inv);
        assertEquals(inv, guitarPartOut.getMaxInv());
    }
    @Test
    void getMinInv() {
        int inv=5;
        guitarPartIn.setMinInv(inv);
        assertEquals(inv, guitarPartIn.getMinInv());
        guitarPartOut.setMinInv(inv);
        assertEquals(inv, guitarPartOut.getMinInv());
    }

    @Test
    void setMinInv() {
        int inv=5;
        guitarPartIn.setMinInv(inv);
        assertEquals(inv, guitarPartIn.getMinInv());
        guitarPartOut.setMinInv(inv);
        assertEquals(inv, guitarPartOut.getMinInv());
    }
    @Test
    void getProducts() {
        Guitar guitar1 = new Guitar();
        Guitar guitar2 = new Guitar();
        Set<Guitar> myGuitars = new HashSet<>();
        myGuitars.add(guitar1);
        myGuitars.add(guitar2);
        guitarPartIn.setProducts(myGuitars);
        assertEquals(myGuitars, guitarPartIn.getProducts());
        guitarPartOut.setProducts(myGuitars);
        assertEquals(myGuitars, guitarPartOut.getProducts());
    }

    @Test
    void setProducts() {
        Guitar guitar1 = new Guitar();
        Guitar guitar2 = new Guitar();
        Set<Guitar> myGuitars = new HashSet<>();
        myGuitars.add(guitar1);
        myGuitars.add(guitar2);
        guitarPartIn.setProducts(myGuitars);
        assertEquals(myGuitars, guitarPartIn.getProducts());
        guitarPartOut.setProducts(myGuitars);
        assertEquals(myGuitars, guitarPartOut.getProducts());
    }

    @Test
    void testToString() {
        String name="test inhouse part";
        guitarPartIn.setName(name);
        assertEquals(name, guitarPartIn.toString());
        name="test outsourced part";
        guitarPartOut.setName(name);
        assertEquals(name, guitarPartOut.toString());
    }

    @Test
    void testEquals() {
        guitarPartIn.setId(1l);
        GuitarPart newGuitarPartIn =new FenderGuitarPart();
        newGuitarPartIn.setId(1l);
        assertEquals(guitarPartIn, newGuitarPartIn);
        guitarPartOut.setId(1l);
        GuitarPart newGuitarPartOut =new GibsonGuitarPart();
        newGuitarPartOut.setId(1l);
        assertEquals(guitarPartOut, newGuitarPartOut);

    }

    @Test
    void testHashCode() {
        guitarPartIn.setId(1l);
        guitarPartOut.setId(1l);
        assertEquals(guitarPartIn.hashCode(), guitarPartOut.hashCode());
    }
}