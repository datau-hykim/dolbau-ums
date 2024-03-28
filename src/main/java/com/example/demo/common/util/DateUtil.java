package com.example.demo.common.util;

import lombok.experimental.UtilityClass;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

@UtilityClass
public class DateUtil {

    public DateTimeFormatter YYYY_MM_DD = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public DateTimeFormatter YYYY_MM_DD_HH_MM_SS = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public long toUnix(LocalDateTime localDateTime) {
        if(localDateTime == null) return 0;
        return localDateTime.atZone(TimeZone.getDefault().toZoneId()).toEpochSecond();
    }

    public LocalDateTime toDate(long unixTimeMillis) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(unixTimeMillis),
                TimeZone.getDefault().toZoneId());
    }

    public String toString(LocalDateTime localDateTime) {
        if(localDateTime == null) return "";
        return localDateTime.format(YYYY_MM_DD_HH_MM_SS);
    }

    public String toString(LocalDateTime localDateTime, DateTimeFormatter formatter) {
        if(localDateTime == null || formatter == null) return "";
        return localDateTime.format(formatter);
    }

    public String toString(long unixTimeMillis) {
        return toString(toDate(unixTimeMillis));
    }

    public String toString(long unixTimeMillis, DateTimeFormatter formatter) {
        if(formatter == null) return "";
        return toString(toDate(unixTimeMillis), formatter);
    }

}
