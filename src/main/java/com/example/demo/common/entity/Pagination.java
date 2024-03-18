package com.example.demo.common.entity;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Pagination {
    private Integer limit;
    private Integer offset;
}
