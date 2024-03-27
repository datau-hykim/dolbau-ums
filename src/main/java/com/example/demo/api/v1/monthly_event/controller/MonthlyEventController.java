package com.example.demo.api.v1.monthly_event.controller;

import com.example.demo.common.auth.AuthParam;
import com.example.demo.api.v1.monthly_event.dto.MonthlyEventDto;
import com.example.demo.api.v1.monthly_event.service.MonthlyEventService;
import com.example.demo.common.auth.Member;
import com.example.demo.common.page.Pagination;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.example.demo.common.page.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/v1/monthly-events")
public class MonthlyEventController {
    private final MonthlyEventService monthlyEventService;

    @GetMapping()
    public Page<MonthlyEventDto.Response> monthlyEvents(@AuthParam Member member, Pagination pagination){
        return this.monthlyEventService.getMonthlyEventList(member.getPlatformId(), pagination);
    }

    @GetMapping("/{eventId}")
    public MonthlyEventDto.Response monthlyEventsById(@PathVariable long eventId){
        return this.monthlyEventService.getMonthlyEventById(eventId);
    }

    @PostMapping("/{eventId}")
    public void applyEvent(@AuthParam Member member, @PathVariable int eventId){
        MonthlyEventDto.RequestApply requestApply = new MonthlyEventDto.RequestApply(eventId, member);
        monthlyEventService.applyMonthlyEvent(requestApply);
    }
}
