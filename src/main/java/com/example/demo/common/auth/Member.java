package com.example.demo.common.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
public class Member {
    private long memberId;
    private long platformId;
    private String platformNm;
    private String loginTypeCd;
    private String snsTypeCd;
    private String nickname;
    // TODO
}
