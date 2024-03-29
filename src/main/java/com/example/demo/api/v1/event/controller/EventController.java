package com.example.demo.api.v1.event.controller;

import com.example.demo.api.v1.event.dto.EventDto;
import com.example.demo.api.v1.event.service.EventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/events")
public class EventController {
    private final EventService eventService;

    @GetMapping("/{eventId}")
    public EventDto.DetailResponse getEventDetail(@PathVariable Long eventId) {
        return eventService.getEventDetailByEventId(eventId);
    }
}
