package com.marcin.bike.repository;

import com.marcin.bike.model.Bike;
import com.marcin.bike.model.BikeExtras;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BikeExtrasRepository extends JpaRepository<BikeExtras, Long> {
    List<Bike> findByName(String extraName);
}
