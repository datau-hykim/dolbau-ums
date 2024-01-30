package com.example.demo.api.v1.applicant.dto;

import com.example.demo.api.v1.applicant.entity.Applicant;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ApplicantDto {
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Request {
        private int eventId;
        private int memberId;
        private int applicantId;

        @Builder
        public Request(int eventId, int memberId, int applicantId){
            this.eventId = eventId;
            this.memberId = memberId;
            this.applicantId = applicantId;
        }

        public Applicant toEntity() {
            return Applicant.builder()
                    .eventId(this.eventId)
                    .memberId(this.memberId)
                    .build();
        }
    }

    public static class AddressRequest {
        private int eventId;
        private int memberId;
        private int applicantId;
        private String receiveNm;
        private String phoneNum;
        private String addressMain;
        private String addressSub;
        private String postNum;

        @Builder
        public AddressRequest(int eventId, int memberId, int applicantId,
                              String receiveNm, String phoneNum, String addressMain,
                              String addressSub, String postNum){
            this.eventId = eventId;
            this.memberId = memberId;
            this.applicantId = applicantId;
            this.receiveNm = receiveNm;
            this.phoneNum = phoneNum;
            this.addressMain = addressMain;
            this.addressSub = addressSub;
            this.postNum = postNum;
        }

        public Applicant toEntity() {
            return Applicant.builder()
                    .applicantId(this.applicantId)
                    .eventId(this.eventId)
                    .memberId(this.memberId)
                    .receiveNm(this.receiveNm)
                    .phoneNum(this.phoneNum)
                    .addressMain(this.addressMain)
                    .addressSub(this.addressSub)
                    .postNum(this.postNum)
                    .build();
        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Response {
        private int eventId;
        private int applicantId;
        private int platformId;
        private String eventNm;
        private String brandNm;
        private String platformNm;
        private String mainImgUrl;
        private String thumbImgUrl;
        private String detailImgFileUrl;
        private String winningYn;
        private long applicantDtm;

        @Builder
        public Response(Applicant applicant) {
            this.eventId = applicant.getEventId();
            this.applicantId = applicant.getApplicantId();
            this.platformId = applicant.getPlatformId();
            this.eventNm = applicant.getPlatformNm();
            this.brandNm = applicant.getBrandNm();
            //TODO
        }
    }
}
