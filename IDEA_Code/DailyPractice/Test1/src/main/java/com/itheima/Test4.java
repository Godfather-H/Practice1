package com.itheima;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;

class Parent{
    private String Name;
    private int Age;
    Parent(String Name, int Age){
        this.Name = Name;
        this.Age = Age;
    }
}

class Child extends Parent{

    Child(String Name, int Age) {
        super(Name, Age);
    }
}


public class Test4 {
    public static void main(String[] args) {

    }
}
