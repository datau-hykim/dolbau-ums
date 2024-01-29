package com.example.demo.api.v1.event.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Event {
    private int eventId;
    private String eventNm;
    private String brandNm;
    private String drawingType;
    private int winningQuantity;
    private int orderNum;
    private String eventStatus;
    private int mainImgFileId;
    private int thumbnailImgFileId;
    private int detailImgFileId;
    private String eventDisplayYn;
    private long eventApplyStartDtm;
    private long eventApplyEndDtm;
    private long resultAnnounceDtm;
    private long eventEndDtm;
    private long registerDtm;
    private long updateDtm;
}
