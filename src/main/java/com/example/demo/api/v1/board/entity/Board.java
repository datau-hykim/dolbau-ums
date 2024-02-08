package com.example.demo.api.v1.board.entity;

import com.example.demo.constant.BoardPlatformCode;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Board {
    Long boardId;
    String title;
    String content;
    Long createdDtm;
    Long updatedDtm;
    BoardPlatformCode platformCd;
    String showYn;
}
