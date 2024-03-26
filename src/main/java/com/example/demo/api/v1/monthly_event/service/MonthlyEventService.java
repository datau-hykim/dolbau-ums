package com.example.demo.api.v1.monthly_event.service;

import com.example.demo.api.v1.monthly_event.dto.MonthlyEventDto;
import com.example.demo.api.v1.monthly_event.entity.MonthlyEvent;
import com.example.demo.api.v1.monthly_event.mapper.MonthlyEventMapper;
import com.example.demo.common.page.Pagination;
import com.example.demo.common.page.RequestPage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.example.demo.common.page.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class MonthlyEventService {
    private final MonthlyEventMapper monthlyEventMapper;

    public Page<MonthlyEventDto.ResponsePage> getMonthlyEventList(int platformId, Pagination pagination) {
        int eventCnt = this.monthlyEventMapper.selectMonthlyEventCountByPlatformId(platformId);

        List<MonthlyEvent> eventList = this.monthlyEventMapper.selectMonthlyEventByPlatformId(
                RequestPage.builder()
                        .param(platformId)
                        .pagination(pagination)
                        .build()
                        .setTotalCnt(eventCnt)
        );

        List<MonthlyEventDto.ResponsePage> list = eventList.stream().map(MonthlyEventDto.ResponsePage::new)
                .collect(Collectors.toList());

        return PageImpl.<MonthlyEventDto.ResponsePage>builder()
                .list(list)
                .pagination(pagination)
                .build();
    }
}
