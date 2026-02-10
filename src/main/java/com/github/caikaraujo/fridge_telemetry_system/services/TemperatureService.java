package com.github.caikaraujo.fridge_telemetry_system.services;


import com.github.caikaraujo.fridge_telemetry_system.model.Temperature;
import com.github.caikaraujo.fridge_telemetry_system.repository.TemperatureRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemperatureService {

    private final TemperatureRepository repository;

    public TemperatureService(TemperatureRepository repository) {
        this.repository = repository;
    }

    public Temperature RecordTemperature(Temperature temperature) {
        return repository.save(temperature);
    }

    public List<Temperature> findAll(){
        return repository.findAll();
    }
}
