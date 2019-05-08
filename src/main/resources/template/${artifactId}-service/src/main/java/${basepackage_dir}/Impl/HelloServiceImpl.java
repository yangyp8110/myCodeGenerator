package ${basepackage};

import org.springframework.stereotype.Service;

<#include "/java_copyright.include">

@Service("helloService")
public class HelloServiceImpl implements IHelloService {
    @Override
    public void sayHello(String name) {
        System.out.println("hello " + name);
    }
}