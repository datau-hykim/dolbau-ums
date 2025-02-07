package com.example.demo.api.v1.notice.dto;

import com.datau.dolbau.boilerplate.util.DateUtil;
import com.example.demo.api.v1.notice.entity.Notice;

public class NoticeDto {
    public record  Response(long noticeId, String noticeTitle, String noticeContent, String deleteYn, long registerDtm, long updateDtm) {
        Response of(Notice notice) {
            return new Response(
                    notice.getNoticeId(),
                    notice.getNoticeTitle(),
                    notice.getNoticeContent(),
                    notice.getDeleteYn(),
                    DateUtil.toUnix(notice.getRegisterDtm()),
                    DateUtil.toUnix(notice.getUpdateDtm())
            );
        }
    }
}
