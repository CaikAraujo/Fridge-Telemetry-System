package com.github.caikaraujo.fridge_telemetry_system.utils;

import com.github.caikaraujo.fridge_telemetry_system.model.Temperature;

import java.util.List;

public class TemperatureCalculator {

    public static Double calculateAvarege(List<Temperature> temperatures){
        return temperatures.stream().mapToDouble(Temperature::getValue).average().orElse(0.0);
    }

    public static Double calculateMax(List<Temperature> temperatures){
        return temperatures.stream().mapToDouble(Temperature::getValue).max().orElse(0.0);
    }

    public static Double calculateMin(List<Temperature> temperatures){
        return temperatures.stream().mapToDouble(Temperature::getValue).min().orElse(0.0);
    }


}
