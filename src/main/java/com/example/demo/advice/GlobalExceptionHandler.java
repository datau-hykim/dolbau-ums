package com.example.demo.advice;

import com.example.demo.common.ApiResponse;
import com.example.demo.common.exception.BizException;
import com.example.demo.constant.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    protected ResponseEntity<ApiResponse<?>> handleException(Exception ex) {
        log.error("", ex);
        ErrorCode errorCode = ErrorCode.INTERNAL_SERVER_ERROR;

        return ResponseEntity
                .status(errorCode.getStatus())
                .body(new ApiResponse<>(errorCode));
    }

    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    protected ResponseEntity<ApiResponse<?>> handleMismatchException(MethodArgumentTypeMismatchException ex) {
        log.error("", ex);
        ErrorCode errorCode = ErrorCode.BAD_PARAMETER;

        return ResponseEntity
                .status(errorCode.getStatus())
                .body(new ApiResponse<>(errorCode, List.of("파라미터 " + ex.getName() + "의 타입이 잘못되었습니다.")));
    }

    @ExceptionHandler(value = BindException.class)
    protected ResponseEntity<ApiResponse<?>> handleBindException(BindException ex) {
        log.error("", ex);
        ErrorCode errorCode = ErrorCode.BAD_PARAMETER;

        return ResponseEntity
                .status(errorCode.getStatus())
                .body(
                        new ApiResponse<>(
                                errorCode,
                                ex.getFieldErrors().stream()
                                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                                    .collect(Collectors.toList())
                        )
                );
    }

    @ExceptionHandler(value = BizException.class)
    protected ResponseEntity<ApiResponse<?>> handleBizException(BizException ex) {
        log.error("", ex);
        ErrorCode errorCode = ex.getErrorCode();

        return ResponseEntity
                .status(errorCode.getStatus())
                .body(new ApiResponse<>(errorCode));
    }

}
