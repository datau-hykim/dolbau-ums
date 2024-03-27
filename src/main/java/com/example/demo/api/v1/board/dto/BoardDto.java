package com.example.demo.api.v1.board.dto;

import com.example.demo.annotation.DuConstraint;
import com.example.demo.api.v1.board.entity.Board;
import com.example.demo.common.data.PaginationList;
import com.example.demo.constant.BoardPlatformCode;
import com.example.demo.common.util.DuDate;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
public class BoardDto {
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    @Builder
    public static class Request {
        @NotNull
        private Long boardId;

        public Board toEntity() {
            return Board.builder()
                    .boardId(this.boardId)
                    .build();
        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    @Builder
    public static class ListRequest {
        @NotNull
        @Min(value = 1)
        @Max(value = 10)
        private Integer limit;
        @NotNull
        @Min(value = 0)
        private Integer offset;

        public PaginationList toEntity() {
            return PaginationList.builder()
                    .limit(this.limit)
                    .offset(this.offset)
                    .build();
        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    @Builder
    public static class RegisterRequest {
        @DuConstraint.NotNullAndBetween2And20
        private String title;
        @NotNull
        @Size(min=2, max=200)
        private String content;
        @NotNull
        @DuConstraint.BoardPlatformCode
        private String platformCd;

        public Board toEntity() {
            return Board.builder()
                    .title(this.title)
                    .content(this.content)
                    .platformCd(BoardPlatformCode.findCodeByKey(this.platformCd).orElse(null))
                    .build();
        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    @Builder
    public static class ModifyRequest {
        @NotNull
        private Long boardId;
        @DuConstraint.NotNullAndBetween2And20
        private String title;
        @NotNull
        @Size(min=2, max=200)
        private String content;
        @NotNull
        @DuConstraint.BoardPlatformCode
        private String platformCd;

        public Board toEntity() {
            return Board.builder()
                    .boardId(this.boardId)
                    .title(this.title)
                    .content(this.content)
                    .platformCd(BoardPlatformCode
                            .findCodeByKey(this.platformCd)
                            .orElse(null))
                    .build();
        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Response {
        private Long boardId;
        private String title;
        private String content;
        private Long createdDtm;
        private Long updatedDtm;
        private String platformCd;
        private String platformStr;
        private String showYn;

        @Builder
        public Response(Board board) {
            this.boardId = board.getBoardId();
            this.title = board.getTitle();
            this.content = board.getContent();
            this.createdDtm = DuDate.toUnix(board.getCreatedDtm());
            this.updatedDtm = DuDate.toUnix(board.getUpdatedDtm());
            if (board.getPlatformCd() != null) {
                this.platformCd = board.getPlatformCd().getKey();
                this.platformStr = board.getPlatformCd().getValue();
            }
            this.showYn = board.getShowYn();
        }
    }
}
