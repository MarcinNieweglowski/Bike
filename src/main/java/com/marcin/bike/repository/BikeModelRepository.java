package com.marcin.bike.repository;

import com.marcin.bike.model.BikeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BikeModelRepository extends JpaRepository<BikeModel, Long> {
}
