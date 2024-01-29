package com.example.demo.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EventDto {
    private Long id;
    private String eventName;
    private String brandName;
    private LocalDateTime startDt;
    private LocalDateTime endDt;

    public EventDto (Long id, String eventName, String brandName) {
        this.id = id;
        this.eventName = eventName;
        this.brandName = brandName;

        LocalDateTime now = LocalDateTime.now();
        this.startDt = now;
        this.endDt = now;
    }

}
