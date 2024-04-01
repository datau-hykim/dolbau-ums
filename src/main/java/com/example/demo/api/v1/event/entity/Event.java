package com.example.demo.api.v1.event.entity;

import com.example.demo.constant.EventAnnouncementType;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Event {

  private Long eventId;
  private String eventNm;
  private String eventApplyUrl;
  private String eventContent;
  private String eventHint;
  private String eventHost;
  private Long eventApplyTypeId;
  private Long eventApplyPlatformId;
  private EventAnnouncementType eventAnnouncementType;
  private LocalDateTime eventAnnouncementDt;
  private LocalDateTime eventStartDt;
  private LocalDateTime eventEndDt;
  private String deleteYn;
  private String blockYn;
  private Long eventImageFileId;
  private Long eventViews;
  private Long eventApplicants;
  private Long eventInterests;
  private Long registerMemberId;
  private LocalDateTime registerDtm;
  private Long updateMemberId;
  private LocalDateTime updateDtm;

}
