package com.github.caikaraujo.fridge_telemetry_system.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

        private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM HH:mm");

        public static String fomatLocalDateTime(LocalDateTime dateTime){

            if(dateTime == null) return  "";
            return dateTime.format(formatter);

        }
}
