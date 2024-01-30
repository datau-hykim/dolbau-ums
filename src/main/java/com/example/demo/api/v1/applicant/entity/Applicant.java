package com.example.demo.api.v1.applicant.entity;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Applicant {
    private int applicantId;
    private int winningId;
    private int addressId;
    private int memberId;
    private int eventId;
    private int platformId;
    private String eventNm;
    private String brandNm;
    private String platformNm;
    private int mainImgFileId;
    private String mainImgUrl;
    private int thumbImgFileId;
    private String thumbImgUrl;
    private int detailImgFileId;
    private String detailImgUrl;
    private String receiveNm;
    private String phoneNum;
    private String addressMain;
    private String addressSub;
    private String postNum;
    private long eventApplyStartDtm;
    private long eventApplyEndDtm;
    private long resultAnnounceDtm;
    private long eventEndDtm;
    private long applicantDtm;
}
