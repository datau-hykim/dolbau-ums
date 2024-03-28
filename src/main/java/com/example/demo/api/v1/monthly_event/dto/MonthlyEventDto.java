package com.example.demo.api.v1.monthly_event.dto;

import com.example.demo.api.v1.monthly_event.entity.MonthlyEvent;
import com.example.demo.api.v1.monthly_event.entity.MonthlyEventApplicant;
import com.example.demo.common.auth.Member;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.ZoneId;

public class MonthlyEventDto {

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class RequestApply {
        private int eventId;
        private int platformId;
        private long memberId;

        public RequestApply(int eventId, Member member) {
            this.eventId = eventId;
            this.memberId = member.getMemberId();
            this.platformId = member.getPlatformId();
        }

        public MonthlyEventApplicant toEntity() {
            return MonthlyEventApplicant.builder()
                    .eventId(this.eventId)
                    .memberId(this.memberId)
                    .platformId(this.platformId)
                    .build();
        }
    }

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

