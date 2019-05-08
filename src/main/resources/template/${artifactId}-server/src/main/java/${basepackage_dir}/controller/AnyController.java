package ${basepackage}.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

<#include "/java_copyright.include">

@RestController
public class AnyController {
    @RequestMapping(value = "/**/*")
    public void any(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(String.format("url:%s not found", request.getRequestURL().toString()));
        response.setStatus(HttpStatus.NOT_FOUND.value());
    }
}