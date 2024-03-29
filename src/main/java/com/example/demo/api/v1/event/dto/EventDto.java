package com.example.demo.api.v1.event.dto;

import com.example.demo.api.v1.event.entity.Event;
import com.example.demo.api.v1.event.entity.EventKeyword;
import com.example.demo.common.util.DuDate;
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
        private long eventAnnouncementType;
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
            this.eventAnnouncementType = event.getEventAnnouncementType();
            if (event.getEventAnnouncementDt() != null) {
                this.eventAnnouncementDt = DuDate.toUnix(event.getEventAnnouncementDt());
            }
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
}
