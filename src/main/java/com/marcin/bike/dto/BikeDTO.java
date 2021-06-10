package com.marcin.bike.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
public class BikeDTO {

    private Long id;

    private String userName;

    private String email;

    private String phone;

    private Long modelId;

    private String serialNumber;

    private BigDecimal totalPrice;

    private Date purchaseDate;

    private boolean contact;

    private Set<Long> bikeExtras = new HashSet<>();

}
