package com.example.demo.api.v1.event.mapper;

import com.example.demo.api.v1.event.dto.EventDTO;
import com.example.demo.api.v1.event.entity.Event;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EventMapper {
    Event selectEventById(String eventId);
    List<Event> selectEventList();

    long insertEventApply(EventDTO.ApplyRequest params);

}
