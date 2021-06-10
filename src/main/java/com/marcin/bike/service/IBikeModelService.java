package com.marcin.bike.service;

import com.marcin.bike.model.BikeModel;

import java.util.List;

public interface IBikeModelService {

    BikeModel get(Long id);

    List<BikeModel> list();

    BikeModel create(BikeModel model);

    void delete(long id);
}
