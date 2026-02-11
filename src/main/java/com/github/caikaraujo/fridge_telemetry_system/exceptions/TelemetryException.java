package com.github.caikaraujo.fridge_telemetry_system.exceptions;

import com.github.caikaraujo.fridge_telemetry_system.enums.TmErrorCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class TelemetryException extends RuntimeException{

    private final String code;
    private final HttpStatus httpStatus;

    public TelemetryException(TmErrorCode error){

        super(error.getMessage());
        this.code = error.getCode();
        this.httpStatus = error.getHttpStatus();


    }

}
