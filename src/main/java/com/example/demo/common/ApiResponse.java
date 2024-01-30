package com.example.demo.common;

import com.example.demo.enums.ErrorCode;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ApiResponse<T> {
    private String code;
    private String message;
    private T result;

    public ApiResponse(T result) {
        this.result = result;
        this.code = ErrorCode.SUCCESS.getCode();
        this.message = ErrorCode.SUCCESS.getMessage();
    }

    public ApiResponse(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    @Builder
    public ApiResponse(T result, ErrorCode errorCode) {
        this.result = result;
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }
}
