package com.example.demo.httpclient.post;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="postClient", url="${service.post.endpoint}")
public interface PostClient {

    @GetMapping("/posts")
    public List<PostDto.Response> getPostList();

    @GetMapping("/posts/{id}")
    public PostDto.Response getPostById(@PathVariable Long id);

    @PostMapping("/posts")
    public PostDto.Response registerPost(PostDto.RegisterRequest params);

    @PutMapping("/posts/{id}")
    public PostDto.Response modifyPost(@PathVariable Long id, @RequestBody PostDto.ModifyRequest params);
}
