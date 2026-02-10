package com.github.caikaraujo.fridge_telemetry_system.repository;

import com.github.caikaraujo.fridge_telemetry_system.model.DailySummary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailySummaryRepository extends JpaRepository<DailySummary, Long> {}
