package com.example.demo.api.v1.event.entity;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Event {
    private int eventId;
    private int memberId;
    private String eventNm;
    private String brandNm;
    private String drawingType;
    private int winningQuantity;
    private int orderNum;
    private String eventStatus;
    private int mainImgFileId;
    private String mainImgUrl;
    private int thumbnailImgFileId;
    private String thumbnailImgUrl;
    private int detailImgFileId;
    private String detailImgUrl;
    private String eventDisplayYn;
    private long eventApplyStartDtm;
    private long eventApplyEndDtm;
    private long resultAnnounceDtm;
    private long eventEndDtm;
    private long registerDtm;
    private long updateDtm;
    private int applicantId;
    private long applicantDtm;
}
