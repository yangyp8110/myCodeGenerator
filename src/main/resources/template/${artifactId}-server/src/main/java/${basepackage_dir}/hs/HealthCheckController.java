package ${basepackage}.hs;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ${basepackage}.utils.annotation.IgnoreResponseAdvice;

<#include "/java_copyright.include">

@RestController
@RequestMapping("/")
public class HealthCheckController {
    @IgnoreResponseAdvice
    @RequestMapping("/hs")
    public String health(){
        return "OK";
    }
}