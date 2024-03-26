package com.example.demo.common;

import lombok.*;
import org.springframework.data.domain.Pageable;

@Getter
@Setter
@Builder
public class ApiRequestList<T> {
    private T param;
    private Pageable pageable;
}