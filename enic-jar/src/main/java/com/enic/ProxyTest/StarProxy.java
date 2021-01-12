package com.enic.ProxyTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class StarProxy implements InvocationHandler {

    private Object target;


    public void setTarget(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("布置演唱会");
        Object invoke = method.invoke(target, args);
        System.out.println(invoke);
        return null;
    }

    // 生成代理类
    public Object CreateProxyObj() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    public static void main(String[] args) {
        LiuDeHua target=new LiuDeHua();
        StarProxy proxy=new StarProxy();
        proxy.setTarget(target);
        star star = (star) proxy.CreateProxyObj();
        star.dance();
        star.sing();
    }
}
