package design_patterns;

//实现部分 - 颜色接口
interface Color {
    void applyColor();
}

class Red implements Color {
    @Override
    public void applyColor() {
        System.out.println("Applying red color");
    }
}

class Blue implements Color {
    @Override
    public void applyColor() {
        System.out.println("Applying blue color");
    }
}

//抽象部分  - 形状类
abstract class Fashion {
    protected Color color;

    public Fashion(Color color){
        this.color = color;
    }

    abstract void draw();
}

class Triangle extends Fashion {
    public Triangle(Color color){
        super(color);
    }

    @Override
    void draw() {
        System.out.print("Drawing a triangle.");
        color.applyColor();
    }
}

class Square extends Fashion{
    public Square(Color color){
        super(color);
    }
    @Override
    void draw() {
        System.out.print("Drawing a square.");
        color.applyColor();
    }
}

//在这个示例中，Color接口代表颜色的实现部分，Red和Blue分别是实现了颜色接口的具体颜色类。
//Shape是形状的抽象部分，具有一个颜色引用， 而Triangle 和 Square 是继承自Shape的具体形状类。
//这种设计允许我们在不改变形状或颜色的情况下，独立地对它们进行扩展和变化。
public class BridgePatternExample {
    public static void main(String[] args){
        Color redColor = new Red();
        Color blueColor = new Blue();

        Fashion redTriangle = new Triangle(redColor);
        Fashion blueSquare = new Square(blueColor);

        redTriangle.draw();
        blueSquare.draw();
    }
}
