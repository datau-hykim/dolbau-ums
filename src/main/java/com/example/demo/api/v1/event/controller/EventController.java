package com.example.demo.api.v1.event.controller;

import com.example.demo.api.v1.board.dto.BoardDto;
import com.example.demo.api.v1.event.model.Event;
import com.example.demo.api.v1.event.service.EventService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/events")
public class EventController {
    private final EventService eventService;

    @PostMapping()
    public void registerEvent(@RequestBody Event event) {
        this.eventService.saveEvent(event);
        Event result = this.eventService.getEventById(event.getId());
        log.info("find :: {}", result);
    }

    @GetMapping("/title/search")
    public Page<Event> searchByTitle(@RequestBody Event event) {
        return this.eventService.getEventByTitle(event.getTitle());
    }

    @GetMapping("/search")
    public Page<Event> searchByTitleAndContents(@RequestBody Map<String, String> params) {
        return this.eventService.getEventByTitleAndContents(params.get("keyword"));
    }
}
