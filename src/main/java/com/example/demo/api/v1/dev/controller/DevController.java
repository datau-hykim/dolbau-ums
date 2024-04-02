package com.example.demo.api.v1.dev.controller;

import com.example.demo.api.v1.dev.dto.DevDto;
import com.example.demo.api.v1.dev.service.DevService;
import com.example.demo.common.util.CryptoUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.security.GeneralSecurityException;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/dev")
public class DevController {
    private final DevService devService;
    private final CryptoUtil crypto;

    /**
     * Sample of HttpClient(OpenFeign)
     */
    @GetMapping("/posts/{postId}")
    public DevDto.PostDetailResponse getPostDetailByPostId(@PathVariable Long postId) {
        return devService.selectPostDetailByPostId(postId);
    }

    /**
     * 암/복호화 테스트
     */
    @GetMapping("/encrypt")
    public DevDto.EncryptResponse getCipherText(@Valid @RequestParam String text) throws GeneralSecurityException {
        String cipherText = crypto.encrypt(text);

        return DevDto.EncryptResponse.builder()
                .cipherText(cipherText)
                .build();
    }

    @GetMapping("/decrypt")
    public DevDto.DecryptResponse getPlainText(@Valid @RequestParam String text) throws GeneralSecurityException {
        String plainText = crypto.decrypt(text);

        return DevDto.DecryptResponse.builder()
                .plainText(plainText)
                .build();
    }

    @GetMapping("/hash")
    public DevDto.HashResponse getHashText(@Valid @RequestParam String text) throws GeneralSecurityException {
        String hashText = crypto.hash(text, "testSalt");

        return DevDto.HashResponse.builder()
                .hashText(hashText)
                .build();
    }
}
