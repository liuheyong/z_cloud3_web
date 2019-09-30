package com.cloud3.web.cjlibdynamicproxy.service;

public class SomeService {

    public String doSome() {
        System.out.println("执行了无接口的目标方法doSome");
        return "abcd";
    }
}
