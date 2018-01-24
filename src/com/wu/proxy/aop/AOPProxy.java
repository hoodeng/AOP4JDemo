package com.wu.proxy.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by wudeng on 18/1/24.
 */
public class AOPProxy implements InvocationHandler {

    private Object target; // 代理目标
    private Object proxy; // 代理对象

    private AOPProxy() {
    }

    /**
     * 通过Class来生成动态代理对象Proxy
     *
     * @param clazz
     * @return
     */
    public synchronized static <T> T getProxyInstance(Class<T> clazz) {
        AOPProxy proxy = new AOPProxy();
        try {
            T tar = clazz.newInstance();
            proxy.setTarget(tar);
            proxy.setProxy(Proxy.newProxyInstance(tar.getClass().getClassLoader(),
                    tar.getClass().getInterfaces(), proxy));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) proxy.getProxy();
    }

    public synchronized static <T> T getProxyInstance(Object o) {
        AOPProxy proxy = new AOPProxy();
        try {
            proxy.setTarget(o);
            proxy.setProxy(Proxy.newProxyInstance(o.getClass().getClassLoader(),
                    o.getClass().getInterfaces(), proxy));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) proxy.getProxy();
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println(method.getName() + "   start");
        Object result = method.invoke(target, args);
        System.out.println(method.getName() + "   end");

        return result;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Object getProxy() {
        return proxy;
    }

    public void setProxy(Object proxy) {
        this.proxy = proxy;
    }
}
