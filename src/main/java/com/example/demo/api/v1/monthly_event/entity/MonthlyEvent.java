package com.example.demo.api.v1.monthly_event.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class MonthlyEvent {
    private int eventId;
    private String eventNm;
    private String brandNm;
    private String mainImgUrl;
    private String thumbImgUrl;
    private String detailImgUrl;
    private int winningQuantity;
    private LocalDateTime eventApplyStartDtm;
    private LocalDateTime eventApplyEndDtm;
}
