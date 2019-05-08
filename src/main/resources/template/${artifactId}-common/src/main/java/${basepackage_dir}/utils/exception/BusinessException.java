package ${basepackage}.utils.exception;

import lombok.Getter;
import lombok.Setter;

<#include "/java_copyright.include">

@Getter
@Setter
public class BusinessException extends RuntimeException {
    private Integer code;
    private String tips;
    private Object content;

    public BusinessException(Integer code, String tips, Object object, String error, Throwable throwable) {
        super(error, throwable);
        this.code = code;
        this.tips = tips;
        this.content = object;
    }

    public BusinessException(Integer code, String tips, Object object, String error) {
        this(code, tips, object, error, null);
    }

    public BusinessException(Integer code, String tips, Object object) {
        this(code, tips, object, null);
    }

    public BusinessException(Integer code, String tips, String error) {
        this(code, tips, null, error);
    }

    public BusinessException(Integer code, String tips) {
        this(code, tips, null, null);
    }
}