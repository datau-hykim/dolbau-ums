package com.example.demo.api.v1.notice.service;

import com.example.demo.api.v1.notice.dto.NoticeDto;
import com.example.demo.api.v1.notice.entity.Notice;
import com.example.demo.api.v1.notice.mapper.NoticeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoticeService {
    private final NoticeMapper noticeMapper;

    /*public NoticeDto.Response getNoticeList() {
        return this.noticeMapper.selectNoticeList();
    }*/
}
