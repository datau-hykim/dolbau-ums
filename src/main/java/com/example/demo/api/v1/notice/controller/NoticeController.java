package com.example.demo.api.v1.notice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    public void getNoticeList(){
        log.info("get notice list");
    }
}
