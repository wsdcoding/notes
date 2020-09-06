package com.wsdcoding.reflex;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description:
 * @Authror wsdcoding
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class rc = Class.forName("com.wsdcoding.reflex.ReflectionDemo");
        ReflectionDemo r = (ReflectionDemo) rc.newInstance();
        System.out.println("clsaa name is" + rc.getName());
        //getDeclaredMethod()可以访问私有方法和继承的方法
        Method  getHello = rc.getDeclaredMethod("throwHello", String.class);
        getHello.setAccessible(true);
        Object o = getHello.invoke(r, "Boy");
        System.out.println("GetHello result is  : " + o);
        //获取公有方法用getMethod()
        Method sayHi = rc.getMethod("sayHi", String.class);
        sayHi.invoke(r,"Welcome");
        //获取private name 成员属性

        Field name = rc.getDeclaredField("name");
        name.setAccessible(true);
        name.set(r,"Reflex");
        sayHi.invoke(r, "Welcome2");
    }
}
