package com.example.demo.api.v1.my_event.controller;

import com.example.demo.api.v1.my_event.dto.MyEventDto;
import com.example.demo.api.v1.my_event.service.MyEventService;
import com.example.demo.common.auth.AuthParam;
import com.example.demo.common.auth.Member;
import com.example.demo.common.page.Page;
import com.example.demo.common.page.Pagination;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/v1/my/monthly-events")
public class MyEventController {
    private final MyEventService myEventService;

    @GetMapping()
    public Page<MyEventDto.ResponseList> monthlyEvents(@AuthParam Member member, Pagination pagination){
        return this.myEventService.getMyEventList(member.getMemberId(), pagination);
    }
}
