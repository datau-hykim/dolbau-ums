package com.example.demo.api.v1.event.mapper;

import com.example.demo.api.v1.event.entity.Event;
import com.example.demo.api.v1.event.entity.EventKeyword;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface EventMapper {
    Optional<Event> selectEventByEventId(Long eventId);
    List<EventKeyword> selectEventKeywordsByEventId(Long eventId);
    int insertEvent(Event event);

}
