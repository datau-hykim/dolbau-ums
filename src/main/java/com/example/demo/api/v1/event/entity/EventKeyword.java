package com.example.demo.api.v1.event.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class EventKeyword {

  private Long keywordId;
  private String keywordNm;
  private Long keywordCategoryId;
  private String keywordCategoryNm;

}
