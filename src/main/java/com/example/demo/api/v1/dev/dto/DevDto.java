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
}
