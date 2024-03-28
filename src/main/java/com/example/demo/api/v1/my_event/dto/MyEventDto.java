package com.example.demo.api.v1.my_event.dto;

import com.example.demo.api.v1.monthly_event.entity.MonthlyEvent;
import com.example.demo.api.v1.my_event.entity.MyEvent;
import com.example.demo.common.auth.Member;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.ZoneId;

public class MyEventDto {
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class RequestList {
        private int eventId;
        private int platformId;
        private long memberId;

        public RequestList(int eventId, Member member) {
            this.eventId = eventId;
            this.memberId = member.getMemberId();
            this.platformId = member.getPlatformId();
        }

        public MyEvent toEntity() {
            return MyEvent.builder()
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
        private String eventNm;
        private String brandNm;
        private String platformNm;
        private String mainImgUrl;
        private String thumbImgUrl;
        private String detailImgUrl;
        private String confirmYn = "N";
        private String winningYn = "N";
        private long eventApplyStartDtm;
        private long eventApplyEndDtm;

        public ResponseList(MyEvent myEvent) {
            this.eventId = myEvent.getEventId();
            this.eventNm = myEvent.getEventNm();
            this.brandNm = myEvent.getBrandNm();
            this.platformNm = myEvent.getPlatformNm();
            this.mainImgUrl = myEvent.getMainImgUrl();
            this.thumbImgUrl = myEvent.getThumbImgUrl();
            this.detailImgUrl = myEvent.getDetailImgUrl();
            if(myEvent.getConfirmId() != null) this.confirmYn = "Y";
            if(myEvent.getWinningId() != null) this.winningYn = "Y";
            this.eventApplyStartDtm = myEvent.getEventApplyStartDtm().atZone(ZoneId.systemDefault()).toEpochSecond();
            this.eventApplyEndDtm = myEvent.getEventApplyEndDtm().atZone(ZoneId.systemDefault()).toEpochSecond();
        }
    }
}
