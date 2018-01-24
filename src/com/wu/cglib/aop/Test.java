package com.wu.cglib.aop;

/**
 * Created by wudeng on 18/1/24.
 */
public class Test {
    public static void main(String[] args){
        System.out.println("cglib test");

        Cglib4AOP cglib4AOP = new Cglib4AOP();
        DatabaseHandler handler = (DatabaseHandler) cglib4AOP.getInstance(new DatabaseHandler());

        handler.insert();
    }
}
