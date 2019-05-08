package com.demo.gener.utils;

import lombok.Data;

<#include "/java_copyright.include">

@Data
public class QueryPageBase {
    /**
     * 当前页  第n页
     */
    private Integer pageIndex;
    /**
     * 每页数量
     */
    private Integer pageSize;

    public Integer getPageIndex() {
        if (this.pageIndex == null || this.pageIndex <= 0) {
            this.pageIndex = 1;
        }
        return this.pageIndex;
    }

    public Integer getPageSize() {
        if (this.pageSize == null || this.pageSize <= 0) {
            this.pageSize = 10;
        }
        return this.pageSize;
    }
}
