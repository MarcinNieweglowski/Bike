package com.marcin.bike.controller;

import com.marcin.bike.model.BikeModel;
import com.marcin.bike.service.IBikeModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/model")
public class BikeModelController {

    @Autowired
    private IBikeModelService bikeModelService;

    @GetMapping
    public List<BikeModel> list() {
        return this.bikeModelService.list();
    }

    @GetMapping ("/{id}")
    public BikeModel get(@PathVariable("id") long id) {
        return this.bikeModelService.get(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.OK)
    public BikeModel create(@RequestBody BikeModel model) {
        return this.bikeModelService.create(model);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        this.bikeModelService.delete(id);
    }
}
