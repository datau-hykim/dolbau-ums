package com.example.demo.api.v1.event.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Event {

  private long eventId;
  private String eventNm;
  private String eventApplyUrl;
  private String eventContent;
  private String eventHint;
  private String eventHost;
  private long eventApplyTypeId;
  private long eventApplyPlatformId;
  private long eventAnnouncementType;
  private LocalDateTime eventAnnouncementDt;
  private LocalDateTime eventStartDt;
  private LocalDateTime eventEndDt;
  private String deleteYn;
  private String blockYn;
  private long eventImageFileId;
  private long eventViews;
  private long eventApplicants;
  private long eventInterests;
  private long registerMemberId;
  private LocalDateTime registerDtm;
  private long updateMemberId;
  private LocalDateTime updateDtm;

}
