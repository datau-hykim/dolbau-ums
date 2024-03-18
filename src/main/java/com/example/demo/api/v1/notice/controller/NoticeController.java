package com.example.demo.api.v1.notice.controller;

import com.example.demo.api.v1.notice.dto.NoticeDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/notices")
public class NoticeController {

    @GetMapping("/{noticeId}")
    public void getNoticeDetail(@PathVariable Long noticeId){
        log.info("get notice detail by {}", noticeId);

    }

    @GetMapping()
    public void getNoticeList(Pageable pageable){
        log.info("pageable {}", pageable);
        log.info("pageable size {}", pageable.getPageSize());
        log.info("pageable offset {}", pageable.getOffset());
        log.info("pageable pageNumber {}", pageable.getPageNumber());
    }
}
