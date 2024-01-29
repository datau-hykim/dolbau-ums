package com.example.demo.api.v1.event.service;

import com.example.demo.api.v1.event.dto.EventDTO;
import com.example.demo.api.v1.event.entity.Event;
import com.example.demo.api.v1.event.entity.EventApply;
import com.example.demo.api.v1.event.mapper.EventMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class EventService {
    private final EventMapper eventMapper;

    public Event getEvent(String eventId) {
        return this.eventMapper.selectEventById(eventId);
    }

    public List<Event> getEventList() {
        return this.eventMapper.selectEventList();
    }

    public EventApply confirmEventApply(EventDTO.EventApplyRequest params) {
        EventApply eventApply = this.getEventApply(params);

        if(eventApply == null) {
            this.eventMapper.insertEventApplyConfirm(params);
            eventApply = this.getEventApply(params);
        }

        return eventApply;
    }

    public EventApply getEventApply(EventDTO.EventApplyRequest params) {
        return this.eventMapper.selectEventApplyById(params);
    }

    public EventApply applyEvent(EventDTO.EventApplyRequest params) {
        this.eventMapper.insertEventApply(params);
        return this.getEventApply(params);
    }

}
