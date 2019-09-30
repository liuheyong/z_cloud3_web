package com.cloud3.web.cjlibdynamicproxy.proxy;

import com.cloud3.web.cjlibdynamicproxy.service.SomeService;
import net.sf.cglib.proxy.Enhancer;

public class ProxyFactory {
    //定义方法，生成代理对象
    public Object createProxy(Object target) {
        //使用cglib库的Enhancer创建代理对象
        //1.创建Enhancer对象
        Enhancer en = new Enhancer();
        //2.指定目标类--子类是代理类
        en.setSuperclass(SomeService.class);
        //3.指定功能增强的方法拦截器对象
        en.setCallback(new MyMethodInterceptor(target));
        //4.创建代理对象
        return en.create();
    }
}
