package com.luoli.proxyCglib;


import com.luoli.proxyJdk.TargetInterface;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        //目标对象
        final Target target=new Target();
        //增强对象
        final Advice advice=new Advice();
        //返回值就是动态生成的代理对象 基于cglib
        //1.创建增强器
        Enhancer enhancern = new Enhancer();
        //2.设置父类
        enhancern.setSuperclass(Target.class);
        //3.设置回调
        enhancern.setCallback(new MethodInterceptor() {
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                advice.before(); //执行前置方法
                Object invoke = method.invoke(target, args);//执行目标
                advice.after();//执行后置方法
                return invoke;
            }
        });
        //4.创建代理对象
        Target proxy = (Target) enhancern.create();
        proxy.save();

    }
}
