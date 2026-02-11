package com.github.caikaraujo.fridge_telemetry_system.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorResponse {

    private LocalDateTime datestamp = LocalDateTime.now();
    private Integer status;
    private String error;
    private String message;
    private String path;

}
