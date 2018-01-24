package com.wu.proxy.aop;

/**
 * Created by wudeng on 18/1/24.
 */
public class IActionImp implements IAction {
    @Override
    public void action() {
        System.out.println("我做了很多东西啊");
    }
}
