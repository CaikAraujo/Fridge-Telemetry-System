package com.github.caikaraujo.fridge_telemetry_system.services;


import com.github.caikaraujo.fridge_telemetry_system.enums.TmErrorCode;
import com.github.caikaraujo.fridge_telemetry_system.exceptions.TelemetryException;
import com.github.caikaraujo.fridge_telemetry_system.model.Temperature;
import com.github.caikaraujo.fridge_telemetry_system.repository.TemperatureRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemperatureService {

    private final TemperatureRepository repository;

    public TemperatureService(TemperatureRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Temperature RecordTemperature(Temperature temperature) {

        if (temperature.getValue() < -50.0 || temperature.getValue() > 50.0){
            throw new TelemetryException(TmErrorCode.INVALID_TEMPERATURE);
        }
        return repository.save(temperature);
    }

    public List<Temperature> findAll(){
        return repository.findAll();
    }
}
