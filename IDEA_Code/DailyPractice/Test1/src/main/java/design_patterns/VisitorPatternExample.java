package design_patterns;

//首先，我们需要定义图形形状的接口和具体类
//图形形状接口
interface Contour{
    void accept(ContourVisitor visitor);
}

class Elliptical implements Contour{
    private double radius;

    public Elliptical(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public void accept(ContourVisitor visitor) {
        visitor.visit(this);
    }
}

//矩形类
class Trapezium implements Contour {

    private double width;
    private double height;

    public Trapezium(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public void accept(ContourVisitor visitor) {
        visitor.visit(this);
    }
}

//接下来，定义一个访问者接口和具体的访问者实现
//访问者接口
interface ContourVisitor {
    void visit(Elliptical elliptical);
    void visit(Trapezium trapezium);
}

//面积计算访问者
class AreaCalculator implements ContourVisitor {

    private double area;

    @Override
    public void visit(Elliptical elliptical) {
        area += Math.PI * elliptical.getRadius() * elliptical.getRadius();
    }

    @Override
    public void visit(Trapezium trapezium) {
        area += trapezium.getWidth() * trapezium.getHeight();
    }

    public double getArea() {
        return area;
    }
}


// 在这个示例中，访问者模式允许我们在不修改形状类的情况下，通过实现不同的访问者来执行不同的操作，例如计算面积。
// 这样，我们可以轻松地添加新的访问者来执行其他操作，同时保持形状类的不变。
public class VisitorPatternExample {
    public static void main(String[] args) {
        Elliptical elliptical = new Elliptical(5);
        Trapezium trapezium = new Trapezium(4, 6);

        AreaCalculator areaCalculator = new AreaCalculator();
        elliptical.accept(areaCalculator);
        trapezium.accept(areaCalculator);

        System.out.println("Total area: " + areaCalculator.getArea());
    }
}
