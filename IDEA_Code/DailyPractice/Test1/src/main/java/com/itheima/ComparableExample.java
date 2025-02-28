package com.itheima;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Student implements Comparable<Student> {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.age, other.age);
    }

    public String toString() {
        return "Student {name'" + name + "', age=" + age + "}";
    }
}

public class ComparableExample {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 20));
        students.add(new Student("Bob", 18));
        students.add(new Student("Charlie", 22));

        //使用实现comparable接口的方式实现升序排序
        Collections.sort(students);
        for (Student student: students) {
            System.out.println(student);
        }

        //使用lambda表达式的方式实现降序排序
        Collections.sort(students, (s1, s2) -> s2.getAge() - s1.getAge());
        for (Student student: students) {
            System.out.println(student);
        }
    }
}
