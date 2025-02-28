package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyReflectDemo3 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        /*Method[] methods = aClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }*/

        Class<?> aClass = Class.forName("reflection.Student");
        Method eat = aClass.getDeclaredMethod("eat", String.class);
        Student stu = new Student();
        eat.setAccessible(true);
        String result = (String)eat.invoke(stu, "海鲜大餐");
        System.out.println(result);
    }
}
