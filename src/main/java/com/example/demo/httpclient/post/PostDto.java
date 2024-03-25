package com.example.demo.httpclient.post;

import lombok.*;

public class PostDto {
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @Builder
    public static class RegisterRequest {
        private Long userId;
        private String title;
        private String body;
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @Builder
    public static class ModifyRequest {
        private Long userId;
        private Long id;
        private String title;
        private String body;
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @Builder
    public static class Response {
        private Long userId;
        private Long id;
        private String title;
        private String body;
    }
}
