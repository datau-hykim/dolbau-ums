package com.example.demo.common.page;

import lombok.*;

@Getter
@ToString
public class Pagination {
    private int page = 1;
    private int perPage = 20;
    private int totalPage = 0;
    private int offset = 0;
    private int total = 0;

    public void setPage(int page) {
        this.page = page;
        int p = page - 1;
        if (page < 0) p = 0;
        this.offset = p * this.perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
        int p = this.page - 1;
        if (this.page < 0) p = 0;
        this.offset = p * this.perPage;
    }

    public void setTotal(int total) {
        this.total = total;
        this.totalPage = (int) Math.ceil((double) total / this.perPage);
    }
}
