package com.example.demo.domain;

import com.example.demo.validators.ValidEnufParts;
import com.example.demo.validators.ValidProductPrice;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 *
 *
 *
 *
 */
@Entity
@Table(name="Guitars")
@ValidProductPrice
@ValidEnufParts
public class Guitar implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String name;
    @Min(value = 0, message = "Price value must be positive")
    double price;
    @Min(value = 0, message = "Inventory value must be positive")
    int inv;
    @ManyToMany(cascade=CascadeType.ALL, mappedBy = "guitars")
    Set<GuitarPart> guitarParts = new HashSet<>();

    public Guitar() {
    }

    public Guitar(String name, double price, int inv) {
        this.name = name;
        this.price = price;
        this.inv = inv;
    }

    public Guitar(long id, String name, double price, int inv) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.inv = inv;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getInv() {
        return inv;
    }

    public void setInv(int inv) {
        this.inv = inv;
    }

    public Set<GuitarPart> getParts() {
        return guitarParts;
    }

    public void setParts(Set<GuitarPart> guitarParts) {
        this.guitarParts = guitarParts;
    }

    public String toString(){
        return this.name;
    }
    public Timestamp getupdatedate(){return  updatedate;}
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Guitar guitar = (Guitar) o;

        return id == guitar.id;
    }

    @CreationTimestamp
    private Timestamp createdate;
    @UpdateTimestamp
    public Timestamp updatedate;
    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
