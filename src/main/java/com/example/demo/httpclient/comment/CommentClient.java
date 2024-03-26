package com.example.demo.httpclient.comment;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="comment-client", url="${external-servers.comment-client.endpoint}")
public interface CommentClient {

    @GetMapping("")
    public List<CommentDto.Response> getCommentList();

    @GetMapping("{postId}")
    public CommentDto.Response getCommentsByPostId(@PathVariable Long postId);
}
