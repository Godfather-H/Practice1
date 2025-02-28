package com.itheima.practice;

import java.util.HashMap;
import java.util.Map;

// 定义原型接口
interface Prototype {
    Prototype copy(); // 方法默认 public
}

// 抽象形状类
abstract class Form implements Prototype {
    protected String id;
    protected String type;

    abstract void draw();

    public String toString() {
        return "Form ID: " + id + ", Type: " + type;
    }
}

// 矩形类
class Rectangle extends Form {
    public Rectangle() {
        type = "Rectangle";
    }

    @Override
    void draw() {
        System.out.println("Drawing a Rectangle");
    }

    @Override
    public Prototype copy() { // 确保用 public 访问修饰符
        Rectangle rectangleClone = new Rectangle();
        rectangleClone.id = this.id; // 复制 id
        return rectangleClone;
    }
}

// 正方形类
class Square extends Form {
    public Square() {
        type = "Square";
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Square");
    }

    @Override
    public Prototype copy() { // 确保用 public 访问修饰符
        Square squareClone = new Square();
        squareClone.id = this.id;
        return squareClone;
    }
}

// 形状注册中心
class FormRegistry {
    private Map<String, Form> formMap = new HashMap<>();

    public void addForm(String key, Form form) {
        formMap.put(key, form);
    }

    public Form getForm(String key) {
        Form cachedForm = formMap.get(key);
        return (Form) cachedForm.copy(); // 克隆并返回
    }
}

public class PrototypeClient {
    public static void main(String[] args) {
        FormRegistry formRegistry = new FormRegistry();

        Rectangle rectangle = new Rectangle();
        rectangle.id = "1";
        formRegistry.addForm("Rectangle", rectangle);

        Square square = new Square();
        square.id = "2";
        formRegistry.addForm("Square", square);

        // 克隆一个 Rectangle
        Form clonedRectangle = formRegistry.getForm("Rectangle");
        System.out.println(clonedRectangle); // 输出: Form ID: 1, Type: Rectangle
        clonedRectangle.draw(); // 输出: Drawing a Rectangle

        // 克隆一个 Square
        Form clonedSquare = formRegistry.getForm("Square");
        System.out.println(clonedSquare); // 输出: Form ID: 2, Type: Square
        clonedSquare.draw(); // 输出: Drawing a Square
    }
}