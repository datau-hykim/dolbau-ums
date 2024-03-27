package com.example.demo.api.v1.monthly_event.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class MonthlyEventApplicant {
    private long applicantId;
    private int eventId;
    private int platformId;
    private long memberId;
    private LocalDateTime registerDtm;
}
