package com.example.demo.advice;

import com.example.demo.common.ApiResponse;
import com.example.demo.common.exception.BizException;
import com.example.demo.constant.error.ErrorCode;
import com.example.demo.constant.error.ErrorCodeImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    // 공통
    @ExceptionHandler(value = Exception.class)
    protected ResponseEntity<ApiResponse<?>> handleException(Exception ex) {
        log.error("", ex);
        ErrorCodeImpl errorCode = ErrorCodeImpl.INTERNAL_SERVER_ERROR;

        return ResponseEntity
                .status(errorCode.getStatus())
                .body(new ApiResponse<>(errorCode));
    }

    // 404
    @ExceptionHandler(value = NoHandlerFoundException.class)
    protected ResponseEntity<ApiResponse<?>> handleNoHandlerFoundException(NoHandlerFoundException ex) {
        log.error("", ex);
        ErrorCodeImpl errorCode = ErrorCodeImpl.NOT_FOUND;

        return ResponseEntity
                .status(errorCode.getStatus())
                .body(new ApiResponse<>(errorCode));
    }

    // Request Http body가 잘못된 경우
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    protected ResponseEntity<ApiResponse<?>> handleNotReadableException(HttpMessageNotReadableException ex) {
        log.error("", ex);
        ErrorCodeImpl errorCode = ErrorCodeImpl.BAD_PARAMETER;

        return ResponseEntity
                .status(errorCode.getStatus())
                .body(new ApiResponse<>(errorCode));
    }

    // Request 데이터 (Body, path variable...) 매핑 시 Type이 mismatch 된 경우
    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    protected ResponseEntity<ApiResponse<?>> handleMismatchException(MethodArgumentTypeMismatchException ex) {
        log.error("", ex);
        ErrorCodeImpl errorCode = ErrorCodeImpl.BAD_PARAMETER;

        return ResponseEntity
                .status(errorCode.getStatus())
                .body(new ApiResponse<>(errorCode, List.of("파라미터 " + ex.getName() + "의 타입이 잘못되었습니다.")));
    }

    // Request @Valid 실패한 경우
    @ExceptionHandler(value = BindException.class)
    protected ResponseEntity<ApiResponse<?>> handleBindException(BindException ex) {
        log.error("", ex);
        ErrorCodeImpl errorCode = ErrorCodeImpl.BAD_PARAMETER;

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

    // custom exception: bizException
    @ExceptionHandler(value = BizException.class)
    protected ResponseEntity<ApiResponse<?>> handleBizException(BizException ex) {
        log.error("", ex);
        ErrorCode errorCode = ex.getErrorCode();

        return ResponseEntity
                .status(errorCode.getStatus())
                .body(new ApiResponse<>(errorCode));
    }

}
