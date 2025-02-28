package com.itheima.practice;

// 抽象形状接口
interface Shape {
    void draw();
}

//具体的圆形实现
class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

//具体的矩形实现
class RedRectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }
}

//具体的红色圆形实现
class RedCircle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Red Circle");
    }
}

//具体的蓝色圆形实现
class BlueCircle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Blue Circle");
    }
}

//具体的蓝色矩形实现
class BlueRectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Blue Rectangle");
    }
}

//抽象工厂接口
interface ShapeFactory {
    Shape createCircle();
    Shape createRectangle();
}

//红色形状工厂
class RedShapeFactory implements ShapeFactory {
    @Override
    public Shape createCircle() {
        return new RedCircle();
    }

    @Override
    public Shape createRectangle() {
        return new RedRectangle();
    }
}

//蓝色形状工厂
class BlueShapeFactory implements ShapeFactory {
    @Override
    public Shape createCircle() {
        return new BlueCircle();
    }

    @Override
    public Shape createRectangle() {
        return new BlueRectangle();
    }
}

public class AbstractFactoryClient {
    public static void main(String[] args) {
        //创建红色形状工厂
        ShapeFactory redFactory = new RedShapeFactory();
        Shape redCircle = redFactory.createCircle();
        Shape redRectangle = redFactory.createRectangle();

        redCircle.draw();
        redRectangle.draw();

        //创建蓝色形状工厂
        ShapeFactory blueFactory = new BlueShapeFactory();
        Shape blueCircle = blueFactory.createCircle();
        Shape blueRectangle = blueFactory.createRectangle();

        blueCircle.draw();
        blueRectangle.draw();
    }
}
