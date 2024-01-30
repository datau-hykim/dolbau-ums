package com.example.demo.enums;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    SUCCESS(HttpStatus.OK, "00000", ""),
    INVALID_ACCESS_TOKEN(HttpStatus.UNAUTHORIZED, "10001", "잘못된 접근입니다. 유효한 토큰이 아닙니다."),
    EXPIRED_ACCESS_TOKEN(HttpStatus.UNAUTHORIZED, "10002", "액세스 토큰이 만료되었습니다. 리프레시 하거나 다시 로그인 해야 합니다."),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "99999", "Internal Server Error")
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;

    ErrorCode(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
