package com.example.demo.api.v1.dev.dto;

import com.example.demo.httpclient.comment.CommentDto;
import com.example.demo.httpclient.post.PostDto;
import lombok.*;

public class DevDto {
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @Builder
    public static class PostDetailResponse {
        private PostDto.Response post;
        private CommentDto.Response comment;
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @Builder
    public static class EncryptResponse {
        private String cipherText;
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @Builder
    public static class DecryptResponse {
        private String plainText;
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @Builder
    public static class HashResponse {
        private String hashText;
    }
}
