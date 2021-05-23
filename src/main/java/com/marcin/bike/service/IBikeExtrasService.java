package com.marcin.bike.service;

import com.marcin.bike.model.Bike;
import com.marcin.bike.model.BikeExtras;

import java.util.List;

public interface IBikeExtrasService {

    List<BikeExtras> list();

    BikeExtras save(BikeExtras bikeExtra);

    BikeExtras get(Long id);
}
