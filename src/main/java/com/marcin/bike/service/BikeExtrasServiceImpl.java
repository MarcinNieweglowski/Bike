package com.marcin.bike.service;

import com.marcin.bike.model.Bike;
import com.marcin.bike.model.BikeExtras;
import com.marcin.bike.repository.BikeExtrasRepository;
import com.marcin.bike.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BikeExtrasServiceImpl implements IBikeExtrasService {

    @Autowired
    private BikeExtrasRepository bikeExtrasRepository;

    @Override
    public List<BikeExtras> list() {
        return this.bikeExtrasRepository.findAll();
    }

    @Override
    public BikeExtras save(BikeExtras bikeExtras) {
        System.out.println(bikeExtras);
        return this.bikeExtrasRepository.save(bikeExtras);
    }

    @Override
    public BikeExtras get(Long id) {
        return this.bikeExtrasRepository.getOne(id);
    }
}
