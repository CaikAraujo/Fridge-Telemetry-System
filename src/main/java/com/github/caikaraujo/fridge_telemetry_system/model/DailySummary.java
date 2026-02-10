package com.github.caikaraujo.fridge_telemetry_system.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class DailySummary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false , updatable = false)
    private LocalDateTime datestamp = LocalDateTime.now();

    private Double avaregeTemperature;
    private Double maxTemperature;
    private Double minTemperature;
}
