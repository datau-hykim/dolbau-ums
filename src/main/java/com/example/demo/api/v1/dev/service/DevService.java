package com.example.demo.api.v1.dev.service;

import com.example.demo.api.v1.dev.dto.DevDto;
import com.example.demo.httpclient.comment.CommentClient;
import com.example.demo.httpclient.comment.CommentDto;
import com.example.demo.httpclient.post.PostClient;
import com.example.demo.httpclient.post.PostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DevService {
    /*private final PostClient postClient;
    private final CommentClient commentClient;*/
    public DevDto.PostDetailResponse selectPostDetailByPostId(Long postId) {
        /*PostDto.Response post = postClient.getPostById(postId);
        CommentDto.Response comment = commentClient.getCommentsByPostId(postId);*/

        return DevDto.PostDetailResponse.builder()
                .post(null)
                .comment(null)
                .build();
    }
}
