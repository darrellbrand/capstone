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
@DiscriminatorValue("2")
public class GibsonGuitarPart extends GuitarPart {


    public GibsonGuitarPart() {
        companyName  = "gibson";
    }
}
