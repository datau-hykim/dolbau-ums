package com.example.demo.api.v1.event.controller;

import com.example.demo.api.v1.event.dto.EventDto;
import com.example.demo.api.v1.event.entity.Event;
import com.example.demo.api.v1.event.service.EventService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    ("")
    public EventDto.RegisterResponse registerEvent(@Valid @RequestBody EventDto.RegisterRequest params) {
        return eventService.registerEvent(params);
    }
}
