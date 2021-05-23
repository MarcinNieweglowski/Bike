package com.marcin.bike.controller;

import com.marcin.bike.model.Bike;
import com.marcin.bike.model.BikeExtras;
import com.marcin.bike.service.IBikeExtrasService;
import com.marcin.bike.service.IBikeService;
import com.marcin.bike.service.dto.BikeDTO;
import com.marcin.bike.service.dto.BikeTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/bikes")
public class BikeController {

    @Autowired
    private IBikeService bikeService;

    @Autowired
    private IBikeExtrasService bikeExtrasService;

    @GetMapping
    public List<Bike> list() {
        return this.bikeService.list();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Bike create(@RequestBody Bike bike) {
        return this.bikeService.save(bike);
    }

    @GetMapping("/{id}")
    public BikeDTO get(@PathVariable("id") long id) {
        Bike bike = this.bikeService.get(id);

        return BikeTransformer.toDto(bike);
    }

    @GetMapping("/extras")
    public List<BikeExtras> listExtras() {
        return this.bikeExtrasService.list();
    }
    @GetMapping("/test")
    public Bike test() {
        Bike bike = new Bike();
        BikeExtras extra = new BikeExtras();
        extra.setName("engine max 1000");
        extra.setPurchasePrice(BigDecimal.ONE);

        bike.setName("test");
        bike.setEmail("test@test.com");
        bike.setPhone("test-123");
        bike.setModel("test model 9000 PRO");
        bike.setSerialNumber("test-asd-vvv");
        bike.setPurchasePrice(BigDecimal.TEN);
        bike.setPurchaseDate(new Date());

        return bikeService.save(bike);
    }


    @PostMapping("/extra")
    @ResponseStatus(HttpStatus.OK)
    public BikeExtras create(@RequestBody BikeExtras bikeExtras) {
        return this.bikeExtrasService.save(bikeExtras);
    }

    @GetMapping("/error")
    public String error() {
        return "something went wrong";
    }
}
