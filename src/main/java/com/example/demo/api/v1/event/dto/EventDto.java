package com.example.demo.api.v1.event.dto;

import com.example.demo.api.v1.event.entity.Event;
import lombok.*;

public class EventDto {
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class ApplyRequest {
        private int eventId;
        private int memberId;

        @Builder
        public ApplyRequest(int eventId, int memberId){
            this.eventId = eventId;
            this.memberId = memberId;
        }

        public Event toEntity() {
            return Event.builder()
                    .eventId(this.eventId)
                    .memberId(this.memberId)
                    .build();
        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Response {
        private int eventId;
        private String eventNm;
        private String brandNm;
        private int winningQuantity;
        private int orderNum;
        private String mainImgUrl;
        private String thumbImgUrl;
        private String detailImgFileUrl;

        @Builder
        public Response(Event event) {
            this.eventId = event.getEventId();
            this.eventNm = event.getEventNm();
            this.brandNm = event.getBrandNm();
            this.winningQuantity = event.getWinningQuantity();
            this.orderNum = event.getOrderNum();
            this.mainImgUrl = event.getMainImgUrl();
            this.thumbImgUrl = event.getThumbImgUrl();
            this.detailImgFileUrl = event.getDetailImgUrl();
        }
    }

}
