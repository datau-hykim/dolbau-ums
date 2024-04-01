package com.example.demo.api.v1.event.dto;

import com.example.demo.api.v1.event.entity.Event;
import com.example.demo.api.v1.event.entity.EventKeyword;
import com.example.demo.common.util.DuDate;
import com.example.demo.common.validator.IsAnnouncementType;
import com.example.demo.common.validator.IsYn;
import com.example.demo.constant.EventAnnouncementType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

public class EventDto {

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class DetailResponse {
        private long eventId;
        private String eventNm;
        private String eventApplyUrl;
        private String eventContent;
        private String eventHint;
        private String eventHost;
        private long eventApplyTypeId;
        private long eventApplyPlatformId;
        private String eventAnnouncementType;
        private long eventAnnouncementDt;
        private long eventStartDt;
        private long eventEndDt;
        private String deleteYn;
        private String blockYn;
        private long eventImageFileId;
        private List<EventKeyword> keywordList;
        private long eventViews;
        private long eventApplicants;
        private long eventInterests;
        private long registerMemberId;
        private long registerDtm;
        private long updateMemberId;
        private long updateDtm;

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
            if (event.getEventAnnouncementType() != null)
                this.eventAnnouncementType = event.getEventAnnouncementType().getValue();
            if (event.getEventAnnouncementDt() != null)
                this.eventAnnouncementDt = DuDate.toUnix(event.getEventAnnouncementDt());
            this.eventStartDt = DuDate.toUnix(event.getEventStartDt());
            this.eventEndDt = DuDate.toUnix(event.getEventEndDt());
            this.deleteYn = event.getDeleteYn();
            this.blockYn = event.getBlockYn();
            this.eventImageFileId = event.getEventImageFileId();
            this.keywordList = keywordList;
            this.eventViews = event.getEventViews();
            this.eventApplicants = event.getEventApplicants();
            this.eventInterests = event.getEventInterests();
            this.registerMemberId = event.getRegisterMemberId();
            this.registerDtm = DuDate.toUnix(event.getRegisterDtm());
            this.updateMemberId = event.getUpdateMemberId();
            this.updateDtm = DuDate.toUnix(event.getUpdateDtm());
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
        @IsAnnouncementType
        private String eventAnnouncementType;
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
                    .eventAnnouncementType(EventAnnouncementType.findCodeByKey(this.eventAnnouncementType).orElse(null))
                    .eventAnnouncementDt(DuDate.toDate(this.eventAnnouncementDt))
                    .eventStartDt(DuDate.toDate(this.eventStartDt))
                    .eventEndDt(DuDate.toDate(this.eventEndDt))
                    .eventImageFileId(this.eventImageFileId)
                    .build();
        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class RegisterResponse {
        private long eventId;

        @Builder
        public RegisterResponse(Long eventId) {
            this.eventId = eventId;
        }
    }
}
