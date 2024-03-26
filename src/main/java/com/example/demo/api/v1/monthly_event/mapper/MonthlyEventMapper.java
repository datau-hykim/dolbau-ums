package com.example.demo.api.v1.monthly_event.mapper;

import com.example.demo.api.v1.monthly_event.entity.MonthlyEvent;
import com.example.demo.common.ApiRequestList;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MonthlyEventMapper {
    List<MonthlyEvent> selectMonthlyEventByPlatformId(ApiRequestList request);

    int selectMonthlyEventCountByPlatformId(int platformId);
}
