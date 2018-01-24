package com.wu.proxy.aop;

/**
 * Created by wudeng on 18/1/24.
 */
public class IActionImpB implements IAction {
    @Override
    public void action() {
        System.out.println("action B");
    }
}
