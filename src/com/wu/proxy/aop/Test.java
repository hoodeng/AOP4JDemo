package com.wu.proxy.aop;

/**
 * Created by wudeng on 18/1/24.
 */
public class Test {
    public static void main(String[] args){
        System.out.println("Hello AOP");

        IAction action = AOPProxy.getProxyInstance(IActionImp.class);
        action.action();

        action = AOPProxy.getProxyInstance(new IActionImpB());
        action.action();
    }
}
