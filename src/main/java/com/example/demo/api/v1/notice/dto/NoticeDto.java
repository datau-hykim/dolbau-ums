package com.example.demo.api.v1.notice.dto;

import com.example.demo.api.v1.applicant.entity.Applicant;
import com.example.demo.api.v1.notice.entity.Notice;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;

public class NoticeDto {
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class DetailRequest {
        private int noticeId;

        @Builder
        public DetailRequest(int noticeId){
            this.noticeId = noticeId;
        }

        public Notice toEntity() {
            return Notice.builder()
                    .noticeId(this.noticeId)
                    .build();
        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class NoticeResponse {
        private int noticeId;
        private String noticeTitle;
        private String noticeContent;
        private String deleteYn;
        LocalDateTime registerDtm;
        LocalDateTime updateDtm;

        @Builder
        public NoticeResponse(Notice notice) {
            this.noticeId = notice.getNoticeId();
            this.noticeTitle = notice.getNoticeTitle();
            this.noticeContent = notice.getNoticeContent();
            this.deleteYn = notice.getDeleteYn();
            this.registerDtm = notice.getRegisterDtm();
            this.updateDtm = notice.getUpdateDtm();
        }
    }
}
