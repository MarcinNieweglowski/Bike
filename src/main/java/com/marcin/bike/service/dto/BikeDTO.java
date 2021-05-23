package com.marcin.bike.service.dto;

import com.marcin.bike.model.BikeExtras;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
public class BikeDTO {

    private Long id;

    private String name;

    private String email;

    private String phone;

    private String model;

    private String serialNumber;

    private BigDecimal totalPrice;

    private Date purchaseDate;

    private boolean contact;

    private Set<BikeExtras> bikeExtras = new HashSet<>();

}
