package com.github.caikaraujo.fridge_telemetry_system.controller;


import com.github.caikaraujo.fridge_telemetry_system.model.Temperature;
import com.github.caikaraujo.fridge_telemetry_system.services.TemperatureService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/temperatures")
public class TemperatureController {

    private final TemperatureService service;

    public TemperatureController(TemperatureService service) {
        this.service = service;
    }

    @PostMapping
    public Temperature save(@RequestBody Temperature temperature){
        return service.RecordTemperature(temperature);
    }

    @GetMapping
    public List<Temperature> getAll(){
        return service.findAll();
    }
}
