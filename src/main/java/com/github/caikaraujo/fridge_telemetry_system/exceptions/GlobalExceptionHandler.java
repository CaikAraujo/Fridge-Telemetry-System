package com.github.caikaraujo.fridge_telemetry_system.exceptions;

import com.github.caikaraujo.fridge_telemetry_system.model.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TelemetryException.class)
    public ResponseEntity<ErrorResponse> handlerTelemetryException(TelemetryException exception,
                                                            HttpServletRequest request){

        ErrorResponse response = new ErrorResponse(LocalDateTime.now(), exception.getHttpStatus().value(), exception.getCode(),
                exception.getMessage(), request.getRequestURI());

        return ResponseEntity.status(exception.getHttpStatus().value()).body(response);


    }
}
