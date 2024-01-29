package com.example.demo.service;

import com.example.demo.dto.EventDto;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
@RequiredArgsConstructor
public class UnitService {

    private final AtomicLong eventIdCreator = new AtomicLong(0);
    private final List<EventDto> events = new ArrayList<>();

    @PostConstruct
    public void setUp() {
        events.add(new EventDto(eventIdCreator.incrementAndGet(), "event name" + eventIdCreator.incrementAndGet(),"brand name" + eventIdCreator.incrementAndGet()));
        events.add(new EventDto(eventIdCreator.incrementAndGet(), "event name" + eventIdCreator.incrementAndGet(), "brand name" + eventIdCreator.incrementAndGet()));
        events.add(new EventDto(eventIdCreator.incrementAndGet(), "event name" + eventIdCreator.incrementAndGet(), "brand name" +  eventIdCreator.incrementAndGet()));
        events.add(new EventDto(eventIdCreator.incrementAndGet(), "event name" + eventIdCreator.incrementAndGet(), "brand name" + eventIdCreator.incrementAndGet()));
        events.add(new EventDto(eventIdCreator.incrementAndGet(), "event name" + eventIdCreator.incrementAndGet(), "brand name" + eventIdCreator.incrementAndGet()));
    }

    public EventDto getEvent(Long eventId) {
        System.out.println(events);
        return events.stream()
                .filter(it -> it.getId().equals(eventId)).findFirst()
                .orElseThrow();
    }

}
