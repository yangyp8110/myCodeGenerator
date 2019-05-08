package com.demo.gener.utils;

import lombok.Data;

import java.util.List;

<#include "/java_copyright.include">

@Data
public class QueryPageResponse<T> {
    /**
     * 当前页  第n页
     */
    private Integer pageIndex;
    /**
     * 每页数量
     */
    private Integer pageSize;
    /**
     * 总页数
     */
    private Integer totalPage;
    /**
     * 总记录数
     */
    private Integer totalCount;
    /**
     * 集合
     */
    private List<T> dataList;
}
