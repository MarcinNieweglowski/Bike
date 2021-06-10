package com.marcin.bike.service;

import com.marcin.bike.model.Bike;
import com.marcin.bike.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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
        return this.bikeRepository.save(bike);
    }

    @Override
    public Bike get(Long id) {
        return this.bikeRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        Optional<Bike> bike = this.bikeRepository.findById(id);
        if (bike.isPresent())
            this.bikeRepository.delete(bike.get());
    }
}
