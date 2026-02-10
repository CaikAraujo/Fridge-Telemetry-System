package com.github.caikaraujo.fridge_telemetry_system.repository;

import com.github.caikaraujo.fridge_telemetry_system.model.Temperature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemperatureRepository extends JpaRepository <Temperature, Long> {}
