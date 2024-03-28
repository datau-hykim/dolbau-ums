package com.example.demo.api.v1.my_event.service;

import com.example.demo.api.v1.my_event.dto.MyEventDto;
import com.example.demo.api.v1.my_event.entity.MyEvent;
import com.example.demo.api.v1.my_event.mapper.MyEventMapper;
import com.example.demo.common.page.Page;
import com.example.demo.common.page.Pagination;
import com.example.demo.common.page.RequestPage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class MyEventService {
    private final MyEventMapper myEventMapper;
    public Page<MyEventDto.ResponseList> getMyEventList(long memberId, Pagination pagination) {
        RequestPage reqPage = RequestPage.builder()
                .param(memberId)
                .pagination(pagination)
                .build();

        int eventCnt = this.myEventMapper.selectMyEventCount(reqPage);
        pagination.setTotal(eventCnt);

        List<MyEvent> eventList =  this.myEventMapper.selectMyEventList(reqPage);

        List<MyEventDto.ResponseList> list = eventList.stream().map(MyEventDto.ResponseList::new)
                .collect(Collectors.toList());

        return Page.<MyEventDto.ResponseList>builder()
                .list(list)
                .pagination(pagination)
                .build();
    }
}
