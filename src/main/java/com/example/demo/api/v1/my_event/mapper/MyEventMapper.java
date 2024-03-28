package com.example.demo.api.v1.my_event.mapper;

import com.example.demo.api.v1.my_event.entity.MyEvent;
import com.example.demo.common.page.RequestPage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MyEventMapper {
    List<MyEvent> selectMyEventList(RequestPage reqPage);

    int selectMyEventCount(RequestPage reqPage);
}
