package com.marcin.bike.service;

import com.marcin.bike.model.Bike;
import com.marcin.bike.model.BikeExtras;

import java.util.List;
import java.util.Set;

public interface IBikeExtrasService {

    List<BikeExtras> list();

    BikeExtras save(BikeExtras bikeExtra);

    BikeExtras get(Long id);

    List<Bike> getByExtraName(String extraName);

    BikeExtras edit(BikeExtras bikeExtras);

    List<BikeExtras> getSelected(Set<Long> bikeExtras);

    void delete(Long id);
}
