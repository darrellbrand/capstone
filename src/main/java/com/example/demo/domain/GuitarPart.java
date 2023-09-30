package com.example.demo.domain;

import com.example.demo.validators.ValidDeletePart;
import com.example.demo.validators.ValidNotEnoughParts;
import com.example.demo.validators.ValidTooManyParts;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 *
 */
@Entity
@ValidDeletePart
@ValidTooManyParts
@ValidNotEnoughParts
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "part_type", discriminatorType = DiscriminatorType.INTEGER)
@Table(name = "GuitarParts")
public abstract class GuitarPart implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    @NotBlank(message = "name must not be blank")
    String name;
    @Min(value = 0, message = "Price value must be positive")
    double price;
    @Min(value = 0, message = "maxInventory value must be positive")
    int maxInv;
    @Min(value = 0, message = "minInventory value must be positive")
    int minInv;
    @Min(value = 0, message = "Inventory value must be positive")
    int inv;


    @ManyToMany
    @JoinTable(name = "product_part", joinColumns = @JoinColumn(name = "part_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    Set<Guitar> guitars = new HashSet<>();

    public GuitarPart() {
    }

    public GuitarPart(String name, double price, int inv) {
        this.name = name;
        this.price = price;
        this.inv = inv;
    }

    public GuitarPart(long id, String name, double price, int inv) {
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

    public void setMaxInv(int inv) {
        this.maxInv = inv;
    }

    public int getMaxInv() {
        return maxInv;
    }

    public void setMinInv(int inv) {
        this.minInv = inv;
    }

    public int getMinInv() {
        return minInv;
    }

    public void setInv(int inv) {
        this.inv = inv;
    }


    public Set<Guitar> getProducts() {
        return guitars;
    }

    public void setProducts(Set<Guitar> guitars) {
        this.guitars = guitars;
    }

    public String toString() {
        return this.name;
    }
    public Timestamp getupdatedate(){return  updatedate;}
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GuitarPart guitarPart = (GuitarPart) o;

        return id == guitarPart.id;
    }

    public boolean isInventoryValid() {
        return inv >= minInv && inv <= maxInv;
    }
    public String getCompanyName(){ return companyName;}
    public String companyName = "";
    @CreationTimestamp
    private Timestamp createdate;
    @UpdateTimestamp
    public Timestamp updatedate;
    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
