package com.example.demo.common.page;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Pageable;

@Getter
@Setter
@Builder
public class RequestPage<T> {
    private T param;
    private Pagination pagination;

    public RequestPage<T> setTotalCnt(int cnt) {
        this.pagination.setTotal(cnt);
        return this;
    }
}