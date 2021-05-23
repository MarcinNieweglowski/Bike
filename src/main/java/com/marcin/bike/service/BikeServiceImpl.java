package com.marcin.bike.service;

import com.marcin.bike.model.Bike;
import com.marcin.bike.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BikeServiceImpl implements IBikeService {

    @Autowired
    private BikeRepository bikeRepository;

    @Override
    public List<Bike> list() {
        return this.bikeRepository.findAll();
    }

    @Override
    public Bike save(Bike bike) {
        System.out.println(bike);
        return this.bikeRepository.save(bike);
    }

    @Override
    public Bike get(Long id) {
        return this.bikeRepository.getOne(id);
    }
}
