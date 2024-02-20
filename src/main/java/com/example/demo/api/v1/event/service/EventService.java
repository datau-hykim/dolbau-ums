package com.example.demo.api.v1.event.service;

import com.example.demo.api.v1.event.model.Event;
import com.example.demo.api.v1.event.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepository;

    public void saveEvent(Event event) {
        this.eventRepository.save(event);
    }

    public Event getEventById(Long id) {
        return this.eventRepository.findById(id).orElse(null);
    }

    public Page<Event> getEventByTitle(String title) {
        return this.eventRepository.findByTitle(title, Pageable.ofSize(20));
    }

    public Page<Event> getEventByTitleAndContents(String keyword) {
        return this.eventRepository.findByTitleOrContentsLike(keyword, keyword, Pageable.ofSize(20));
    }

}
