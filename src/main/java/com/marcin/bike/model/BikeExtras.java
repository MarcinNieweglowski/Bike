package com.marcin.bike.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @ManyToMany(mappedBy = "bikeExtras",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Bike> bikes = new HashSet<>();

}
