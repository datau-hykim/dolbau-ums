package com.example.demo.controller;

import com.example.demo.enums.ErrorCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ErrorCodeController {

    @GetMapping(value = "/error-code", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, ErrorCodeResponse> findEnums() {
        Map<String, ErrorCodeResponse> map = new HashMap<>();
        for (ErrorCode errorCode : ErrorCode.values()) {
            map.put(errorCode.name(), new ErrorCodeMap());
        }
        return map;
    }

    @Getter
    @NoArgsConstructor
    protected static class ErrorCodeResponse {
        private String code;
        private String message;
        private int status;
        public ErrorCodeResponse(ErrorCode errorCode) {
            this.code = errorCode.getCode();
            this.message = errorCode.getMessage();
            this.status = errorCode.getStatus().value();
        }
    }

}
