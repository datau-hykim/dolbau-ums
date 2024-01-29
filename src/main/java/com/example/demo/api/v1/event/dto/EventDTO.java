package com.example.demo.api.v1.event.dto;

import com.example.demo.api.v1.event.entity.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class EventDTO {


    @Getter
    @Builder
    @ToString
    public static class EventApplyRequest {
        private String eventId;
        private String applyId;
        private String memberId;
    }

    @Getter
    @Builder
    @ToString
    public static class ApplyAddressRequest {
        private int eventId;
        private int applyId;
        private String receiverNm;
        private String phoneNum;
        private String addressMain;
        private String addressSub;
        private String postNum;
    }
}
