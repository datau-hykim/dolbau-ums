package com.example.demo.api.v1.event.controller;

import com.example.demo.annotation.AuthParam;
import com.example.demo.api.v1.event.dto.EventDto;
import com.example.demo.api.v1.event.service.EventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/v1/events")
public class EventController {

    private final EventService eventService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<EventDto.Response> eventList(){
        return this.eventService.getEventList();
    }

    @GetMapping("/{eventId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public EventDto.Response eventDetail(@PathVariable int eventId){
        return this.eventService.getEvent(EventDto.ApplyRequest.builder()
                .eventId(eventId)
                .build()
        );
    }

    @PutMapping("/{eventId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void applyEvent(@PathVariable int eventId, @AuthParam int memberId){
        this.eventService.applyEvent(
                EventDto.ApplyRequest.builder()
                        .eventId(eventId)
                        .memberId(memberId)
                        .build()
        );
    }

}
