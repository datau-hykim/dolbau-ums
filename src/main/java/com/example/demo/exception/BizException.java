package com.example.demo.exception;

import com.example.demo.enums.ErrorCode;

public class BizException extends RuntimeException{
    private ErrorCode errorCode;
    public BizException(ErrorCode errorCode) {
        super(errorCode.getCode() + " : " + errorCode.getMessage());
        this.setErrorCode(errorCode);
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
