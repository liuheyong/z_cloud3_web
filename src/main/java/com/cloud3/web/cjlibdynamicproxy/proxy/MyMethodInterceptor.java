package com.cloud3.web.cjlibdynamicproxy.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 实现对目标方法功能增强
 */
public class MyMethodInterceptor implements MethodInterceptor {

    private Object target = null;

    public MyMethodInterceptor() {
        super();
    }

    public MyMethodInterceptor(Object target) {
        super();
        this.target = target;
    }

    /**
     * 方法作用：拦截对目标方法调用。 用户实际调用执行的是intercept(),在这个方法内部调用目标方法
     * 参数：
     * Object proxyObj:cglib生成的代理对象
     * Method method:目标方法（doSome）
     * Object[] args:方法的参数列表
     * MethodProxy proxy:方法的代理对象
     * <p>
     * 返回值：Object:目标方法执行结果（可以是修改后的结果）
     */
    @Override
    public Object intercept(Object proxyObj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("============intercept==============");
        Object result = null;
        //调用目标方法， 对返回值做修改， 实现小写转大写
        result = method.invoke(target, args);
        //改大写
        if (result != null) {
            String str = (String) result; // final
            result = str.toUpperCase();
        }
        //目标方法的执行结果
        return result;
    }

}
