package com.example.demo.api.v1.monthly_event.dto;

import com.example.demo.api.v1.monthly_event.entity.MonthlyEvent;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.ZoneId;

public class MonthlyEventDto {
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class ResponseList {
        private int eventId;
        private String applicantYn;
        private String eventNm;
        private String brandNm;
        private int winningQuantity;
        private String thumbImgUrl;
        private String mainImgUrl;
        private String detailImgUrl;
        private long eventApplyStartDtm;
        private long eventApplyEndDtm;
        @Builder
        public ResponseList(MonthlyEvent monthlyEvent) {
            this.eventId = monthlyEvent.getEventId();
            this.eventNm = monthlyEvent.getEventNm();
            this.brandNm = monthlyEvent.getBrandNm();
            this.applicantYn = "Y"; //TODO
            this.winningQuantity = monthlyEvent.getWinningQuantity();
            this.thumbImgUrl = monthlyEvent.getThumbImgUrl();
            this.detailImgUrl = monthlyEvent.getDetailImgUrl();
            this.mainImgUrl = monthlyEvent.getMainImgUrl();
            this.eventApplyStartDtm = monthlyEvent.getEventApplyStartDtm().atZone(ZoneId.systemDefault()).toEpochSecond();
            this.eventApplyEndDtm = monthlyEvent.getEventApplyEndDtm().atZone(ZoneId.systemDefault()).toEpochSecond();
        }
    }
}

