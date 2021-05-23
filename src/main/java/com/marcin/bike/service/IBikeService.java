package com.marcin.bike.service;

import com.marcin.bike.model.Bike;

import java.util.List;

public interface IBikeService {

    List<Bike> list();

    Bike save(Bike bike);

    Bike get(Long id);
}
