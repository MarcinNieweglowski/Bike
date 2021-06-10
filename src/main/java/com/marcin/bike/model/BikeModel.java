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
public class BikeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String modelName;

    @NotNull
    private BigDecimal price;

    @Column(name = "serial_number")
    @NotNull
    private String serialNumber;

    @OneToMany(mappedBy = "model")
    @JsonBackReference
    private Set<Bike> bike = new HashSet<>();

}
