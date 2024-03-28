package com.example.demo.api.v1.monthly_event.service;

import com.example.demo.api.v1.monthly_event.dto.MonthlyEventDto;
import com.example.demo.api.v1.monthly_event.entity.MonthlyEvent;
import com.example.demo.api.v1.monthly_event.entity.MonthlyEventApplicant;
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

    public Page<MonthlyEventDto.ResponseList> getMonthlyEventList(long platformId, Pagination pagination) {
        int eventCnt = this.monthlyEventMapper.selectMonthlyEventCountByPlatformId(platformId);
        pagination.setTotal(eventCnt);

        List<MonthlyEvent> eventList = this.monthlyEventMapper.selectMonthlyEventByPlatformId(
                RequestPage.builder()
                        .param(platformId)
                        .pagination(pagination)
                        .build()
        );

        List<MonthlyEventDto.ResponseList> list = eventList.stream().map(MonthlyEventDto.ResponseList::new)
                .collect(Collectors.toList());

        return Page.<MonthlyEventDto.ResponseList>builder()
                .list(list)
                .pagination(pagination)
                .build();
    }

    public MonthlyEventDto.ResponseList getMonthlyEventById(long eventId) throws BizException {
        Optional<MonthlyEvent> item = this.monthlyEventMapper.selectMonthlyEventById(eventId);
        if(item.isEmpty()) {
            throw new BizException(ErrorCodeImpl.MONTHLY_EVENT.NOT_FOUND_EVENT);
        }

        return new MonthlyEventDto.ResponseList(item.get());
    }

    public void applyMonthlyEvent(MonthlyEventDto.RequestApply requestApply) {
        MonthlyEventApplicant applicant = requestApply.toEntity();
        int eventId = requestApply.getEventId();
        // TODO 해당 이벤트 유효성 확인
        this.getMonthlyEventById(eventId);

        // TODO 회원 응모 여부 확인
        Optional<MonthlyEventApplicant> applicantItem =  this.monthlyEventMapper.selectMonthlyEventApplicant(applicant);
        if(applicantItem.isPresent()){
            throw new BizException(ErrorCodeImpl.MONTHLY_EVENT.EXIST_APPLY_EVENT);
        }

        this.monthlyEventMapper.insertMonthlyEventApplicant(applicant);
    }
}
