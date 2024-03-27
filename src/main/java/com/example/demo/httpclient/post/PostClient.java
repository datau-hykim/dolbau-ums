package com.example.demo.httpclient.post;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="post-client", url="${external-servers.post-client.endpoint}")
public interface PostClient {

    @GetMapping("")
    public List<PostDto.Response> getPostList();

    @GetMapping("/{id}")
    public PostDto.Response getPostById(@PathVariable Long id);

    @PostMapping("")
    public PostDto.Response registerPost(PostDto.RegisterRequest params);

    @PutMapping("/{id}")
    public PostDto.Response modifyPost(@PathVariable Long id, @RequestBody PostDto.ModifyRequest params);
}
