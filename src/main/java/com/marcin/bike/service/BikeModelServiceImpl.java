package com.marcin.bike.service;

import com.marcin.bike.model.BikeModel;
import com.marcin.bike.repository.BikeModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BikeModelServiceImpl implements IBikeModelService {

    @Autowired
    private BikeModelRepository bikeModelRepository;

    @Override
    public BikeModel get(Long id) {
        return this.bikeModelRepository.findById(id).get();
    }

    @Override
    public List<BikeModel> list() {
        return this.bikeModelRepository.findAll();
    }

    @Override
    public BikeModel create(BikeModel model) {
        return this.bikeModelRepository.save(model);
    }

    @Override
    public void delete(long id) {
        Optional<BikeModel> bikeModel = this.bikeModelRepository.findById(id);
        if (bikeModel.isPresent())
            this.bikeModelRepository.delete(bikeModel.get());
    }
}
