package com.itheima.log;

import java.lang.reflect.Constructor;

public class ClassTest {
    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("com.itheima.log.Studnet");
        Constructor<?> dc = aClass.getDeclaredConstructor(String.class, int.class);
        dc.setAccessible(true);
        Object tom = dc.newInstance("tom", 21);
        System.out.println(tom);
    }
}
