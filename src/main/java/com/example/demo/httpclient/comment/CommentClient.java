package com.example.demo.httpclient.comment;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="commentClient", url="${service.comment.endpoint}")
public interface CommentClient {

    @GetMapping("/comments")
    public List<CommentDto.Response> getCommentList();

    @GetMapping("/comments/{postId}")
    public CommentDto.Response getCommentsByPostId(@PathVariable Long postId);
}
