package com.example.demo.api.v1.monthly_event.service;

import com.example.demo.api.v1.monthly_event.dto.MonthlyEventDto;
import com.example.demo.api.v1.monthly_event.entity.MonthlyEvent;
import com.example.demo.api.v1.monthly_event.mapper.MonthlyEventMapper;
import com.example.demo.common.exception.BizException;
import com.example.demo.common.page.Pagination;
import com.example.demo.common.page.RequestPage;
import com.example.demo.constant.error.ErrorCodeImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.example.demo.common.page.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class MonthlyEventService {
    private final MonthlyEventMapper monthlyEventMapper;

    public Page<MonthlyEventDto.Response> getMonthlyEventList(long platformId, Pagination pagination) {
        int eventCnt = this.monthlyEventMapper.selectMonthlyEventCountByPlatformId(platformId);
        pagination.setTotal(eventCnt);

        List<MonthlyEvent> eventList = this.monthlyEventMapper.selectMonthlyEventByPlatformId(
                RequestPage.builder()
                        .param(platformId)
                        .pagination(pagination)
                        .build()
        );

        List<MonthlyEventDto.Response> list = eventList.stream().map(MonthlyEventDto.Response::new)
                .collect(Collectors.toList());

        return Page.<MonthlyEventDto.Response>builder()
                .list(list)
                .pagination(pagination)
                .build();
    }

    public MonthlyEventDto.Response getMonthlyEventById(long eventId) throws BizException {
        Optional<MonthlyEvent> item = this.monthlyEventMapper.selectMonthlyEventById(eventId);
        if(item.isEmpty()) {
            throw new BizException(ErrorCodeImpl.MONTHLY_EVENT.NOT_FOUND_EVENT);
        }

        return new MonthlyEventDto.Response(item.get());
    }
}
