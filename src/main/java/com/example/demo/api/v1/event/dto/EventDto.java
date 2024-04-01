package com.example.demo.api.v1.event.dto;

import com.example.demo.api.v1.event.entity.Event;
import com.example.demo.api.v1.event.entity.EventKeyword;
import com.example.demo.common.util.DateUtil;
import com.example.demo.common.validator.IsYn;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

public class EventDto {

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class DetailResponse {
        private Long eventId;
        private String eventNm;
        private String eventApplyUrl;
        private String eventContent;
        private String eventHint;
        private String eventHost;
        private Long eventApplyTypeId;
        private Long eventApplyPlatformId;
        private Long eventAnnouncementTypeId;
        private Long eventAnnouncementDt;
        private Long eventStartDt;
        private Long eventEndDt;
        private String deleteYn;
        private String blockYn;
        private Long eventImageFileId;
        private List<EventKeyword> keywordList;
        private Long eventViews;
        private Long eventApplicants;
        private Long eventInterests;
        private Long registerMemberId;
        private Long registerDtm;
        private Long updateMemberId;
        private Long updateDtm;

        @Builder
        public DetailResponse(Event event, List<EventKeyword> keywordList) {
            this.eventId = event.getEventId();
            this.eventNm = event.getEventNm();
            this.eventApplyUrl = event.getEventApplyUrl();
            this.eventContent = event.getEventContent();
            this.eventHint = event.getEventHint();
            this.eventHost = event.getEventHost();
            this.eventApplyTypeId = event.getEventApplyTypeId();
            this.eventApplyPlatformId = event.getEventApplyPlatformId();
            if (event.getEventAnnouncementTypeId() != null)
                this.eventAnnouncementTypeId = event.getEventAnnouncementTypeId();
            if (event.getEventAnnouncementDt() != null)
                this.eventAnnouncementDt = DateUtil.toUnix(event.getEventAnnouncementDt());
            this.eventStartDt = DateUtil.toUnix(event.getEventStartDt());
            this.eventEndDt = DateUtil.toUnix(event.getEventEndDt());
            this.deleteYn = event.getDeleteYn();
            this.blockYn = event.getBlockYn();
            this.eventImageFileId = event.getEventImageFileId();
            this.keywordList = keywordList;
            this.eventViews = event.getEventViews();
            this.eventApplicants = event.getEventApplicants();
            this.eventInterests = event.getEventInterests();
            this.registerMemberId = event.getRegisterMemberId();
            this.registerDtm = DateUtil.toUnix(event.getRegisterDtm());
            this.updateMemberId = event.getUpdateMemberId();
            this.updateDtm = DateUtil.toUnix(event.getUpdateDtm());
        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    @Builder
    public static class RegisterRequest {
        @NotNull
        @Size(min=2, max=30)
        private String eventNm;
        @NotNull
        @Size(min=2, max=300)
        private String eventApplyUrl;
        @NotNull
        @Size(min=2, max=300)
        private String eventContent;
        @NotNull
        @Size(min=2, max=30)
        private String eventHint;
        @NotNull
        @Size(min=2, max=15)
        private String eventHost;
        @NotNull
        private Long eventApplyTypeId;
        @NotNull
        private Long eventApplyPlatformId;
        private Long eventAnnouncementTypeId;
        private Long eventAnnouncementDt;
        @NotNull
        private Long eventStartDt;
        @NotNull
        private Long eventEndDt;
        @NotNull
        private Long eventImageFileId;
        /**
         * 필요시 NotEmpty와 함께 사용
         */
        @IsYn
        @NotEmpty
        private String testYn;

        public Event toEntity() {
            return Event.builder()
                    .eventNm(this.eventNm)
                    .eventApplyUrl(this.eventApplyUrl)
                    .eventContent(this.eventContent)
                    .eventHint(this.eventHint)
                    .eventHost(this.eventHost)
                    .eventApplyTypeId(this.eventApplyTypeId)
                    .eventApplyPlatformId(this.eventApplyPlatformId)
                    .eventAnnouncementTypeId(this.eventAnnouncementTypeId)
                    .eventAnnouncementDt(DateUtil.toDate(this.eventAnnouncementDt))
                    .eventStartDt(DateUtil.toDate(this.eventStartDt))
                    .eventEndDt(DateUtil.toDate(this.eventEndDt))
                    .eventImageFileId(this.eventImageFileId)
                    .build();
        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class RegisterResponse {
        private Long eventId;

        @Builder
        public RegisterResponse(Long eventId) {
            this.eventId = eventId;
        }
    }
}
