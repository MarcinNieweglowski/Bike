package com.marcin.bike.repository;

import com.marcin.bike.model.Bike;
import com.marcin.bike.model.BikeExtras;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BikeExtrasRepository extends JpaRepository<BikeExtras, Long> {
}
