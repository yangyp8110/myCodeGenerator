package ${basepackage}.utils.annotation;

import java.lang.annotation.*;

<#include "/java_copyright.include">

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Documented
public @interface IgnoreResponseAdvice {
}