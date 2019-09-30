package com.cloud3.web.cjlibdynamicproxy.test;

import com.cloud3.web.cjlibdynamicproxy.proxy.ProxyFactory;
import com.cloud3.web.cjlibdynamicproxy.service.SomeService;

public class MyTest {

    public static void main(String[] args) {
        //创建目标对象
        SomeService target = new SomeService();
        //创建工具类对象
        ProxyFactory factory = new ProxyFactory();
        //调用工具类的方法，得到代理对象
        SomeService proxy = (SomeService) factory.createProxy(target);
        System.out.println("proxy:" + proxy.getClass().getName());
        //通过代理执行业务方法，实现功能的增强
        String str = proxy.doSome();
        System.out.println("通过代理执行目标方法的结果：" + str);

    }

}
