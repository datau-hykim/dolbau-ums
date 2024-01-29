package com.example.demo.api.v1.event.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventApplyWinningAddress extends EventApply{
    private int applyId;
    private int platformId;
    private String receiveNm;
    private String phoneNum;
    private String addressMain;
    private String addressSub;
    private String postNum;
}
