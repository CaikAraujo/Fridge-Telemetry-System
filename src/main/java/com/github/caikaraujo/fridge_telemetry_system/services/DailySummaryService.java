package com.github.caikaraujo.fridge_telemetry_system.services;

import com.github.caikaraujo.fridge_telemetry_system.model.DailySummary;
import com.github.caikaraujo.fridge_telemetry_system.model.Temperature;
import com.github.caikaraujo.fridge_telemetry_system.repository.DailySummaryRepository;
import com.github.caikaraujo.fridge_telemetry_system.repository.TemperatureRepository;
import com.github.caikaraujo.fridge_telemetry_system.utils.TemperatureCalculator;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
public class DailySummaryService {

    private final DailySummaryRepository summaryRepo;
    private final TemperatureRepository tempRepo;


    public DailySummaryService(DailySummaryRepository summaryRepo, TemperatureRepository tempRepo) {
        this.summaryRepo = summaryRepo;
        this.tempRepo = tempRepo;
    }

    public List<Temperature> getTemp(){
        return tempRepo.findAll();
    }

    public void clearData(){
        tempRepo.deleteAll();
    }

    public DailySummary saveDailySummary() {
        List<Temperature> listTemp = tempRepo.findAll();

        DailySummary resumo = new DailySummary();

        resumo.setAvaregeTemperature(TemperatureCalculator.calculateAvarege(listTemp));
        resumo.setMaxTemperature(TemperatureCalculator.calculateMax(listTemp));
        resumo.setMinTemperature(TemperatureCalculator.calculateMin(listTemp));

        summaryRepo.save(resumo);
        return resumo;
    }

}
