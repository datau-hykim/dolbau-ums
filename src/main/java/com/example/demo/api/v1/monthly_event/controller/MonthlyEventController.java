package com.example.demo.api.v1.monthly_event.controller;

import com.example.demo.api.v1.monthly_event.dto.MonthlyEventDto;
import com.example.demo.api.v1.monthly_event.service.MonthlyEventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/v1/monthly-events")
public class MonthlyEventController {
    private final MonthlyEventService monthlyEventService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Page<MonthlyEventDto.ResponseList> monthlyEvents(@PageableDefault Pageable pageable){
        return this.monthlyEventService.getMonthlyEventList(1, pageable);
    }
}
