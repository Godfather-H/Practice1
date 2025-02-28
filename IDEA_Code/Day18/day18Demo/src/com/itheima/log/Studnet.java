package com.itheima.log;

public class Studnet {
    private String name;
    private int age;

    private Studnet(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Studnet(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Studnet{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
