package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MyReflectDemo1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        /*System.out.println(clazz1);

        Class<Student> clazz2 = Student.class;
        System.out.println(clazz2);
        System.out.println(clazz1 == clazz2);

        Student student = new Student();
        Class<? extends Student> clazz3 = student.getClass();
        System.out.println(clazz3);*/


        /*Constructor[] cons = clazz1.getConstructors();
        for(Constructor c : cons){
            System.out.println(c);
        }*/

       /* Constructor[] declaredConstructors = clazz1.getDeclaredConstructors();
        for(Constructor c : declaredConstructors){
            System.out.println(c);
        }*/

       /* Constructor declaredConstructor = clazz1.getDeclaredConstructor();
        System.out.println(declaredConstructor);*/

       /* Constructor declaredConstructor1 = clazz1.getDeclaredConstructor(int.class);
        System.out.println(declaredConstructor1);*/

        Class clazz1 = Class.forName("reflection.Student");

        Constructor declaredConstructor = clazz1.getDeclaredConstructor(String.class, int.class);

        declaredConstructor.setAccessible(true);

        Student stu = (Student) declaredConstructor.newInstance("张三", 21);

        System.out.println(stu);
    }
}
