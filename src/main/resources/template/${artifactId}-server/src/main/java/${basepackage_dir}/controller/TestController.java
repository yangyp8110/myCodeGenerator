package ${basepackage}.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

<#include "/java_copyright.include">

@RestController
public class TestController {
    @RequestMapping("/hello")
    public String hello() {
        return "hello world";
    }
}