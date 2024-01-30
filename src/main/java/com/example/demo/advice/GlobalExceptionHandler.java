package com.example.demo.advice;

import com.example.demo.common.ApiResponse;
import com.example.demo.enums.ErrorCode;
import com.example.demo.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    protected ApiResponse<?> handleException(Exception ex) {
        log.error("", ex);
        return new ApiResponse<>(ErrorCode.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    protected ResponseEntity<ApiResponse<?>> handleBizException(BizException ex) {
        log.error("", ex);
        ErrorCode errorCode = ex.getErrorCode();
        return ResponseEntity
                .status(errorCode.getStatus())
                .body(ApiResponse.builder().errorCode(errorCode).build());
    }
}
