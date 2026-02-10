package com.github.caikaraujo.fridge_telemetry_system.scheduler;

import com.github.caikaraujo.fridge_telemetry_system.services.DailySummaryService;
import com.github.caikaraujo.fridge_telemetry_system.services.TemperatureService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;



@Component
public class TemperatureScheduler {


    @Scheduled(fixedRate = 5000)
    public void checkSensors(){}

    private final DailySummaryService summaryService;
    private final TemperatureService service;
    public TemperatureScheduler(TemperatureService service, DailySummaryService summaryService) {
        this.service = service;
        this.summaryService = summaryService;
    }

    @Scheduled(cron = "0 */5 * * * *")
    public void generateEndOfDayReport(){
        summaryService.saveDailySummary();
    }


}
