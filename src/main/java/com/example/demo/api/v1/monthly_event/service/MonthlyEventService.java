package com.example.demo.api.v1.monthly_event.service;

import com.example.demo.api.v1.monthly_event.dto.MonthlyEventDto;
import com.example.demo.api.v1.monthly_event.entity.MonthlyEvent;
import com.example.demo.api.v1.monthly_event.mapper.MonthlyEventMapper;
import com.example.demo.common.ApiRequestList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class MonthlyEventService {
    private final MonthlyEventMapper monthlyEventMapper;

    public Page<MonthlyEventDto.ResponseList> getMonthlyEventList(int platformId, Pageable pageable) {
        int eventCnt = this.monthlyEventMapper.selectMonthlyEventCountByPlatformId(platformId);
        log.info("pageable getOffset is {}", pageable.getOffset());
        log.info("pageable getPageNumber is {}", pageable.getPageNumber());
        log.info("pageable getPageSize is {}", pageable.getPageSize());

        List<MonthlyEvent> eventList = this.monthlyEventMapper.selectMonthlyEventByPlatformId(
                ApiRequestList.builder()
                        .param(platformId)
                        .pageable(pageable).build()
        );

        List<MonthlyEventDto.ResponseList> content = eventList.stream().map(MonthlyEventDto.ResponseList::new)
                .collect(Collectors.toList());

        return new PageImpl<>(content, pageable, eventCnt);
    }
}
