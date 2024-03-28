package com.example.demo.api.v1.dev.controller;

import com.example.demo.api.v1.dev.dto.DevDto;
import com.example.demo.api.v1.dev.service.DevService;
import com.example.demo.common.util.DuCrypto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/dev")
public class DevController {
    private final DevService devService;
    private final DuCrypto crypto;

    /**
     * Sample of HttpClient(OpenFeign)
     * https://jsonplaceholder.typicode.com에 데이터를 요청해 가공하고 응답한다.
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
