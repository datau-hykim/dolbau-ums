package com.example.demo.common.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

public class DuDate {
    public static long toUnix(LocalDateTime localDateTime) {
        return localDateTime.atZone(TimeZone.getDefault().toZoneId()).toEpochSecond();
    }

    public static LocalDateTime toDate(long unixTimeMillis) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(unixTimeMillis),
                TimeZone.getDefault().toZoneId());
    }

    public static String formatDtm(LocalDateTime date) {
        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }

    public static String formatDtm(long unixTimeMillis) {
        return formatDtm(toDate(unixTimeMillis));
    }

    public static String formatDt(LocalDateTime date) {
        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public static String formatDt(long unixTimeMillis) {
        return formatDt(toDate(unixTimeMillis));
    }
}
