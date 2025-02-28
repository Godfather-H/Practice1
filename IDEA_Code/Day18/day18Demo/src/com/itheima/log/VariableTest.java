package com.itheima.log;

import java.lang.reflect.Field;

public class VariableTest {
    public static void main(String[] args) throws Exception {
        Class<Studnet> studnetClass = Studnet.class;
        Field name = studnetClass.getDeclaredField("name");
        Field age = studnetClass.getDeclaredField("age");
        name.setAccessible(true);
        age.setAccessible(true);
        Studnet studnet = studnetClass.getDeclaredConstructor().newInstance();
        name.set(studnet,"张三丰");
        age.set(studnet,18);
        System.out.println(studnet);
    }
}
