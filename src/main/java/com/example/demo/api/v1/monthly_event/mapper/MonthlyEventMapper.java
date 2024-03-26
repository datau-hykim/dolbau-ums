package com.example.demo.api.v1.monthly_event.mapper;

import com.example.demo.api.v1.monthly_event.entity.MonthlyEvent;
import com.example.demo.common.ApiRequestList;
import com.example.demo.common.page.RequestPage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MonthlyEventMapper {
    List<MonthlyEvent> selectMonthlyEventByPlatformId(RequestPage pagination);
    int selectMonthlyEventCountByPlatformId(long platformId);

    Optional<MonthlyEvent> selectMonthlyEventById(long eventId);
}
