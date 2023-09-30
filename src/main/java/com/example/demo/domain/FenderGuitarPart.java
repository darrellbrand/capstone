package com.example.demo.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 *
 *
 *
 */
@Entity
@DiscriminatorValue("1")
public class FenderGuitarPart extends GuitarPart {

    public FenderGuitarPart() {
        companyName = "fender";
    }

}
