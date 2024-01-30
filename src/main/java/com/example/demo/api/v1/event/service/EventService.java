package com.example.demo.api.v1.event.service;

import com.example.demo.api.v1.event.dto.EventDto;
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

    public EventDto.Response getEvent(EventDto.ApplyRequest params) {
        return new EventDto.Response(this.eventMapper.selectEventById(params.toEntity()));
    }

    public List<EventDto.Response> getEventList() {
        List<Event> eventList = this.eventMapper.selectEventList();
        return eventList.stream().map(EventDto.Response::new)
                .collect(Collectors.toList());
    }

    public void applyEvent(EventDto.ApplyRequest params) {
        this.eventMapper.insertEventApply(params.toEntity());
    }

}
