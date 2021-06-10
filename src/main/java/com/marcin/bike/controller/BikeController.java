package com.marcin.bike.controller;

import com.marcin.bike.dto.BikeDTO;
import com.marcin.bike.dto.BikeTransformer;
import com.marcin.bike.model.Bike;
import com.marcin.bike.model.BikeExtras;
import com.marcin.bike.model.BikeModel;
import com.marcin.bike.service.IBikeExtrasService;
import com.marcin.bike.service.IBikeModelService;
import com.marcin.bike.service.IBikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/bikes")
public class BikeController {

    @Autowired
    private IBikeService bikeService;

    @Autowired
    private IBikeExtrasService bikeExtrasService;

    @Autowired
    private IBikeModelService bikeModelService;

    @GetMapping
    public List<Bike> list() {
        return this.bikeService.list();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Bike create(@RequestBody BikeDTO bikeDTO) {
        BikeModel model = this.bikeModelService.get(bikeDTO.getModelId());
        List<BikeExtras> extras = this.bikeExtrasService.getSelected(bikeDTO.getBikeExtras());
        Bike bike = BikeTransformer.dtoToBike(bikeDTO, model,extras);
        return this.bikeService.save(bike);
    }

    @GetMapping("/{id}")
    public BikeDTO get(@PathVariable("id") long id) {
        Bike bike = this.bikeService.get(id);
        return BikeTransformer.toDto(bike);
    }

    @GetMapping({"/getByExtra","/getByExtra/{extraName}"})
    public List<Bike> getBikesWithExtra(@PathVariable("extraName") Optional<String> extraName) {
        if (extraName.isPresent())
            return this.bikeExtrasService.getByExtraName(extraName.get());

        return this.bikeExtrasService.getByExtraName(EMPTY);
    }

    @GetMapping("/test")
    public Bike test() {
//        Bike bike = new Bike();
//        BikeExtras extra = new BikeExtras();
//        extra.setName("engine max 1000");
//        extra.setPurchasePrice(BigDecimal.ONE);
//        Set<BikeExtras> extras = new HashSet<>();
//        extras.add(extra);
//
//        BikeModel model = new BikeModel();
//        model.set
//
//        bike.setName("test");
//        bike.setEmail("test@test.com");
//        bike.setPhone("test-123");
//        bike.setModel("test model 9000 PRO");
//        bike.setSerialNumber("test-asd-vvv");
//        bike.setPurchasePrice(BigDecimal.TEN);
//        bike.setPurchaseDate(new Date());
//        bike.setBikeExtras(extras);
//
//        return bikeService.save(bike);
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteBike(@PathVariable("id") long id) {
        this.bikeService.delete(id);
    }

    @GetMapping("/error")
    public String error() {
        return "something went wrong";
    }

    private static final String EMPTY = "";
}
