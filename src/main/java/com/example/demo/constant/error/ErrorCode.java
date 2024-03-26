package com.example.demo.constant.error;

import org.springframework.http.HttpStatus;

import java.util.List;

public interface ErrorCode {
    String getCode();
    HttpStatus getStatus();
    List<String> getMessages();
}
