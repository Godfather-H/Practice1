package com.itheima.practice;

//实现部分-颜色接口
interface Color {
    String applyColor();
}

class Red implements Color {
    public String applyColor() {
        return "Applying red color.";
    }
}

class Green implements Color {
    @Override
    public String applyColor() {
        return "Applying green color.";
    }
}

//抽象部分 - 形状类
abstract class Appearance {
    protected Color color;

    protected Appearance(Color color) {
        this.color = color;
    }

    abstract void draw();

}

//具体的形状类
class Circle1 extends Appearance {
    public Circle1(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.println("Drawing Circle1");
        System.out.println(color.applyColor());
    }
}

class Square1 extends Appearance {
    public Square1(Color color) {
        super(color);
    }

    @Override
    void draw() {
        System.out.print("Drawing Square. ");
        System.out.println(color.applyColor());
    }
}

public class BridgeClient {
    public static void main(String[] args) {
        // 使用红色绘制圆形
        Appearance redCircle = new Circle1(new Red());
        redCircle.draw();

        // 使用绿色绘制正方形
        Appearance greenSquare = new Square1(new Green());
        greenSquare.draw();
    }
}
