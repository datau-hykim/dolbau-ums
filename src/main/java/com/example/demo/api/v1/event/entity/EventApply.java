package com.example.demo.api.v1.event.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventApply extends Event{
    private int applyId;
    private int platformId;
    private int memberId;
}
