package com.example.demo.api.v1.event.mapper;

import com.example.demo.api.v1.event.dto.EventDTO;
import com.example.demo.api.v1.event.entity.Event;
import com.example.demo.api.v1.event.entity.EventApply;
import com.example.demo.api.v1.event.entity.EventApplyWinningAddress;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EventMapper {
    Event selectEventById(String eventId);
    List<Event> selectEventList();
    EventApply selectEventApplyById(EventDTO.EventApplyRequest params);

    EventApplyWinningAddress selectEventApplyWinningAddress(EventDTO.EventApplyRequest params);

    long insertEventApply(EventDTO.EventApplyRequest params);

    long insertEventApplyConfirm(EventDTO.EventApplyRequest params);

}
