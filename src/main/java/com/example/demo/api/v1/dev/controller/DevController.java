package com.example.demo.api.v1.dev.controller;

import com.example.demo.api.v1.dev.dto.DevDto;
import com.example.demo.api.v1.dev.service.DevService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/dev")
public class DevController {
    private final DevService devService;

    /**
     * Sample of HttpClient(OpenFeign)
     * https://jsonplaceholder.typicode.com에 데이터를 요청해 가공하고 응답한다.
     */
    @GetMapping("/posts/{postId}")
    public DevDto.PostDetailResponse getPostDetailByPostId(@PathVariable Long postId) {
        return devService.selectPostDetailByPostId(postId);
    }
}
