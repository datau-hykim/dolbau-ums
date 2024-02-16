package com.example.demo.api.v1.board.entity;

import com.example.demo.constant.BoardPlatformCode;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Board {
    Long boardId;
    String title;
    String content;
    LocalDateTime createdDtm;
    LocalDateTime updatedDtm;
    BoardPlatformCode platformCd;
    String showYn;
}
