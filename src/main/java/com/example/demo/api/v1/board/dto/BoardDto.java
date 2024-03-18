package com.example.demo.api.v1.board.dto;

import com.example.demo.api.v1.board.entity.Board;
import com.example.demo.common.entity.Pagination;
import com.example.demo.constant.BoardPlatformCode;
import jakarta.validation.constraints.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.ZoneId;

@Slf4j
public class BoardDto {
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Request {
        private Long boardId;

        @Builder
        public Request(Long boardId) {
            this.boardId = boardId;
        }
        public Board toEntity() {
            return Board.builder()
                    .boardId(this.boardId)
                    .build();
        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class ListRequest {
        @Min(value = 1, message = "limit은 1 이상이어야 합니다.")
        @Max(value = 10, message = "limit은 10 이하이어야 합니다.")
        @NotNull(message = "limit은 필수 값입니다.")
        private Integer limit;
        @Min(value = 0, message = "offset은 0 이상이어야 합니다.")
        @NotNull(message = "offset은 필수 값입니다.")
        private Integer offset;

        @Builder
        public ListRequest(Integer limit, Integer offset) {
            this.limit = limit;
            this.offset = offset;
        }

        public Pagination toEntity() {
            return Pagination.builder()
                    .limit(this.limit)
                    .offset(this.offset)
                    .build();
        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class RegisterRequest {
        @Size(min = 2, message = "제목은 2자 이상이어야 합니다.")
        @Size(max = 20, message = "제목은 20자 이하이어야 합니다.")
        @NotBlank(message = "제목은 필수 값입니다.")
        private String title;
        @Size(min = 2, message = "내용은 2자 이상이어야 합니다.")
        @Size(max = 200, message = "내용은 200자 이하이어야 합니다.")
        @NotBlank(message = "내용은 필수 값입니다.")
        private String content;
        @NotBlank(message = "이벤트 참여 플랫폼 값은 필수 값입니다.")
        private String platformCd;

        @Builder
        public RegisterRequest(String title, String content, String platformCd) {
            this.title = title;
            this.content = content;
            this.platformCd = platformCd;
        }
        public Board toEntity() {
            return Board.builder()
                    .title(this.title)
                    .content(this.content)
                    .platformCd(BoardPlatformCode.findCodeByKey(this.platformCd))
                    .build();
        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class ModifyRequest {
        private Long boardId;
        @Size(min = 2, message = "제목은 2자 이상이어야 합니다.")
        @Size(max = 20, message = "제목은 20자 이하이어야 합니다.")
        @NotBlank(message = "제목은 필수 값입니다.")
        private String title;
        @Size(min = 2, message = "내용은 2자 이상이어야 합니다.")
        @Size(max = 200, message = "내용은 200자 이하이어야 합니다.")
        @NotBlank(message = "내용은 필수 값입니다.")
        private String content;
        @NotBlank(message = "이벤트 참여 플랫폼 값은 필수 값입니다.")
        private String platformCd;

        @Builder
        public ModifyRequest(Long boardId, String title, String content, String platformCd) {
            this.boardId = boardId;
            this.title = title;
            this.content = content;
            this.platformCd = platformCd;
        }
        public Board toEntity() {
            return Board.builder()
                    .boardId(this.boardId)
                    .title(this.title)
                    .content(this.content)
                    .platformCd(BoardPlatformCode.findCodeByKey(this.platformCd))
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
        private String platformStr;
        private String platformCd;
        private String showYn;

        @Builder
        public Response(Board board) {
            this.boardId = board.getBoardId();
            this.title = board.getTitle();
            this.content = board.getContent();
            this.createdDtm = board.getCreatedDtm().atZone(ZoneId.systemDefault()).toEpochSecond();
            this.updatedDtm = board.getUpdatedDtm().atZone(ZoneId.systemDefault()).toEpochSecond();
            this.platformStr = board.getPlatformCd().getValue();
            this.platformCd = board.getPlatformCd().getKey();
            this.showYn = board.getShowYn();
        }
    }
}
