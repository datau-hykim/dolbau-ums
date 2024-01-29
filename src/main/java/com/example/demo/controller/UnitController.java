package com.example.demo.controller;

import com.example.demo.dto.EventDto;
import com.example.demo.service.UnitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UnitController {
    private final UnitService unitService;

    public UnitController(UnitService unitService) {
        this.unitService = unitService;
    }

    @GetMapping("/")
    public ResponseEntity<Map<String, String>> hello() {
        return ResponseEntity.ok(Map.of("key", "hello"));
    }

    @GetMapping("/event/{id}")
    public EventDto unit(@PathVariable("id") Long eventId)  {
        return unitService.getEvent(eventId);
    }
}
