package com.demo.gener.utils;

import lombok.Data;

import java.util.Date;

<#include "/java_copyright.include">

@Data
public class QueryPageTimeBase extends QueryPageBase {
    /**
     * 开始时间
     */
    private Date startTime;
    /**
     * 结束时间
     */
    private Date endTime;
}
