package com.marcin.bike.service.dto;

import com.marcin.bike.model.Bike;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class BikeTransformer {

    public static BikeDTO toDto (Bike bike) {
        BikeDTO dto = new BikeDTO();
        dto.setName(bike.getName());
        dto.setContact(bike.isContact());
        dto.setEmail(bike.getEmail());
        dto.setModel(bike.getModel());
        dto.setId(bike.getId());
        dto.setPhone(bike.getPhone());
        dto.setSerialNumber(bike.getSerialNumber());
        dto.setPurchaseDate(bike.getPurchaseDate());
        dto.setTotalPrice(calculateTotalPrice(bike));

        System.out.println(dto);
        return dto;
    }

    private static BigDecimal calculateTotalPrice(Bike bike) {
        BigDecimal summed = bike.getBikeExtras().stream().map(extra -> extra.getPurchasePrice()).reduce(BigDecimal.ZERO,BigDecimal::add);
        return summed.add(bike.getPurchasePrice());
    }
}
