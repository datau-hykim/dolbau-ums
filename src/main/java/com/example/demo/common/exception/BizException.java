package com.example.demo.common.exception;

import com.example.demo.constant.ErrorCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BizException extends RuntimeException {
    private ErrorCode errorCode;
    public BizException(ErrorCode errorCode) {
        super(errorCode.getCode() + " : " + errorCode.getMessages());
        this.setErrorCode(errorCode);
    }
}
