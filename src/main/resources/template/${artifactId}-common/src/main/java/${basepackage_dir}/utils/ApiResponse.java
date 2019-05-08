package ${basepackage}.utils;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

<#include "/java_copyright.include">

@Getter
@Setter
public class ApiResponse<T> implements Serializable {
    private Integer code;
    private String message;
    private T ret;
}