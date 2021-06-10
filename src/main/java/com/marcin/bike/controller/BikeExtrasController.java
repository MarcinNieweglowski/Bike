package com.marcin.bike.controller;

import com.marcin.bike.model.BikeExtras;
import com.marcin.bike.service.BikeExtrasServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/extras")
public class BikeExtrasController {

    @Autowired
    private BikeExtrasServiceImpl bikeExtrasService;

    @GetMapping()
    public List<BikeExtras> listExtras() {
        return this.bikeExtrasService.list();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.OK)
    public BikeExtras create(@RequestBody BikeExtras bikeExtras) {
        return this.bikeExtrasService.save(bikeExtras);
    }

    @PutMapping("/edit")
    @ResponseStatus(HttpStatus.OK)
    public BikeExtras edit(@RequestBody BikeExtras bikeExtras) {
        return this.bikeExtrasService.edit(bikeExtras);
    }

    @GetMapping("/{id}")
    public BikeExtras get(@PathVariable("id") long id) {
        return this.bikeExtrasService.get(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        this.bikeExtrasService.delete(id);
    }
}
