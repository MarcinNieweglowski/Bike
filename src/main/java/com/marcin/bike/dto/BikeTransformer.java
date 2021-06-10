package com.marcin.bike.dto;

import com.marcin.bike.model.Bike;
import com.marcin.bike.model.BikeExtras;
import com.marcin.bike.model.BikeModel;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BikeTransformer {

    public static BikeDTO toDto(Bike bike) {
        BikeDTO dto = new BikeDTO();

        dto.setUserName(bike.getUserName());
        dto.setContact(bike.isContact());
        dto.setEmail(bike.getEmail());
        dto.setModelId(bike.getModel().getId());
        dto.setId(bike.getId());
        dto.setPhone(bike.getPhone());
        dto.setSerialNumber(bike.getModel().getSerialNumber());
        dto.setPurchaseDate(bike.getPurchaseDate());
        dto.setTotalPrice(calculateTotalPrice(bike));
        dto.setBikeExtras(getExtrasIds(bike));

        return dto;
    }

    public static Bike dtoToBike(BikeDTO bikeDTO, BikeModel model, List<BikeExtras> extras) {
        Bike bike = new Bike();

        bike.setUserName(bikeDTO.getUserName());
        bike.setEmail(bikeDTO.getEmail());
        bike.setPhone(bikeDTO.getPhone());
        bike.setContact(bikeDTO.isContact());
        bike.setPurchaseDate(bikeDTO.getPurchaseDate() == null ? new Date() : bikeDTO.getPurchaseDate());
        bike.setBikeExtras(new HashSet<>(extras));
        bike.setModel(model);

        return bike;
    }

    private static Set<Long> getExtrasIds(Bike bike) {
        return bike.getBikeExtras().stream().map(BikeExtras::getExtraId).collect(Collectors.toSet());
    }

    private static BigDecimal calculateTotalPrice(Bike bike) {
        BigDecimal summedExtrasPrice = bike.getBikeExtras().stream().map(extra -> extra.getPurchasePrice()).reduce(BigDecimal.ZERO, BigDecimal::add);
        return summedExtrasPrice.add(bike.getModel().getPrice());
    }
}
