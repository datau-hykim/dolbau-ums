package com.example.demo.api.v1.event.service;

import com.example.demo.api.v1.event.dto.EventDTO;
import com.example.demo.api.v1.event.entity.Event;
import com.example.demo.api.v1.event.mapper.EventMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Slf4j
public class EventService {
    private final EventMapper eventMapper;

    public EventDTO.Response getEvent(String eventId) {
        return new EventDTO.Response(this.eventMapper.selectEventById(eventId));
    }

    public List<EventDTO.Response> getEventList() {
        List<Event> eventList = this.eventMapper.selectEventList();
        return eventList.stream().map(EventDTO.Response::new)
                .collect(Collectors.toList());
    }

    public void applyEvent(EventDTO.ApplyRequest params) {
        this.eventMapper.insertEventApply(params);
    }

}
