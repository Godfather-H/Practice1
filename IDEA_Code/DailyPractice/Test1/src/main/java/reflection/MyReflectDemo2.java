package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MyReflectDemo2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        /*Field[] fields = aClass.getDeclaredFields();

        for (Field field : fields) {
            System.out.println(field.getName());
        }*/

       /* Field gender = aClass.getField("gender");
        System.out.println(gender); */

        Class<?> aClass = Class.forName("reflection.Student");
        Field name = aClass.getDeclaredField("name");

        Constructor<?> constructor = aClass.getConstructor(String.class, int.class, String.class);
        Student stu = (Student)constructor.newInstance("张三", 26, "男");
        System.out.println(stu.getName());
        name.setAccessible(true);
        name.set(stu,"李四");
        System.out.println(name.get(stu));
    }
}
