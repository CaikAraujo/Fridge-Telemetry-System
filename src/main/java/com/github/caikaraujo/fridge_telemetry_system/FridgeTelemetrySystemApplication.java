package com.github.caikaraujo.fridge_telemetry_system;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.TimeZone;


@SpringBootApplication
@EnableScheduling
public class FridgeTelemetrySystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(FridgeTelemetrySystemApplication.class, args);
	}

	@PostConstruct
	public void init(){
		TimeZone.setDefault(TimeZone.getTimeZone("Europe/Zurich"));
	}

}
