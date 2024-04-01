package com.example.demo.api.v1.event.service;

import com.example.demo.api.v1.event.dto.EventDto;
import com.example.demo.api.v1.event.entity.Event;
import com.example.demo.api.v1.event.entity.EventKeyword;
import com.example.demo.api.v1.event.mapper.EventMapper;
import com.example.demo.common.exception.BizException;
import com.example.demo.constant.error.ErrorCodeImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EventService {
    private final EventMapper eventMapper;

    public EventDto.DetailResponse getEventDetailByEventId(Long eventId) {
        Event event = eventMapper.selectEventByEventId(eventId)
                .orElseThrow(() -> new BizException(ErrorCodeImpl.EVENT.NOT_FOUND_EVENT));
        List<EventKeyword> keywordList = eventMapper.selectEventKeywordsByEventId(eventId);

        return EventDto.DetailResponse.builder()
                .event(event)
                .keywordList(keywordList)
                .build();
    }

    public EventDto.RegisterResponse registerEvent(EventDto.RegisterRequest params) {
        Event event = params.toEntity();
        // mybatis에 의해 생성된 이벤트의 id가 주입됨
        eventMapper.insertEvent(event);

        return EventDto.RegisterResponse.builder()
                .eventId(event.getEventId())
                .build();
    }
}
