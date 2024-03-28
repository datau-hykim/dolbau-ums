package com.example.demo.api.v1.my_event.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class MyEvent {
    private int eventId;
    private int platformId;
    private long memberId;
    private Integer confirmId;
    private Integer winningId;
    private String eventNm;
    private String brandNm;
    private String platformNm;
    private String mainImgUrl;
    private String thumbImgUrl;
    private String detailImgUrl;
    private int winningQuantity;
    private LocalDateTime eventApplyStartDtm;
    private LocalDateTime eventApplyEndDtm;
}
