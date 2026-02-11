package com.github.caikaraujo.fridge_telemetry_system.enums;


import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum TmErrorCode {

    // --- SENSOR & HARDWARE ERRORS (00X) ---
    SENSOR_NOT_FOUND("TM-001", "Sensor not found with the provided ID", HttpStatus.NOT_FOUND),
    SENSOR_OFFLINE("TM-002", "Sensor is unreachable or offline", HttpStatus.UNPROCESSABLE_ENTITY),
    SENSOR_ALREADY_EXISTS("TM-003", "Sensor ID already registered", HttpStatus.CONFLICT),

    // --- DATA VALIDATION ERRORS (10X) ---
    INVALID_TEMPERATURE("TM-101", "Temperature reading is out of physical bounds", HttpStatus.UNPROCESSABLE_ENTITY),
    MISSING_COORDINATES("TM-102", "Telemetry data is missing mandatory geolocation", HttpStatus.BAD_REQUEST),
    DUPLICATE_READING("TM-103", "Duplicate telemetry data for this timestamp", HttpStatus.CONFLICT),

    // --- INFRASTRUCTURE & SYSTEM ERRORS (50X) ---
    NOTIFICATION_SERVICE_ERROR("TM-501", "Failed to communicate with notification service", HttpStatus.SERVICE_UNAVAILABLE),
    DATABASE_CONSTRAINT("TM-502", "Database integrity constraint violation", HttpStatus.INTERNAL_SERVER_ERROR),
    GENERIC_ERROR("TM-500", "Unexpected internal system error", HttpStatus.INTERNAL_SERVER_ERROR);



    private final String code;
    private final String message;
    private final HttpStatus httpStatus;



    TmErrorCode(String code, String message, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
