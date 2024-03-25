package com.example.demo.httpclient.comment;

import lombok.*;


public class CommentDto {

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @Builder
    public static class Response {
        private Long postId;
        private Long id;
        private String name;
        private String email;
        private String body;
    }
}
