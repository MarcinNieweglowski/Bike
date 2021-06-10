package com.marcin.bike.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class BikeExtras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long extraId;

    private String name;

    @Column(name = "purchase_price")
    private BigDecimal purchasePrice;

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE},
            fetch = FetchType.LAZY,
            mappedBy = "bikeExtras")
    @JsonBackReference
    private Set<Bike> bikes = new HashSet<>();

    @Override
    public String toString() {
        return "Bike id:" + this.extraId + " name:" + this.name;
    }

    @Override
    public int hashCode () {
        return this.name.hashCode();
    }
}
