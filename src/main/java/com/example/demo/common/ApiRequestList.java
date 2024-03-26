package com.example.demo.common;

import com.example.demo.constant.ErrorCode;
import lombok.*;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@Setter
@Builder
public class ApiRequestList<T> {
    private T param;
    private Pageable pageable;
}