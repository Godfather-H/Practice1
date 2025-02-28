package design_patterns;

//创建一个实现Cloneable接口的原型类
class Appearance implements Cloneable {
    private String type;

    public Appearance(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public Appearance clone() {
        try {
            return (Appearance) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
//测试原型模式
public class PrototypeExample {
    public static void main(String[] args) {
        //创建原型对象
        Appearance circle = new Appearance("circle");

        //克隆原型对象来创建新对象
        Appearance clonedCircle = circle.clone();
        clonedCircle.setType("Cloned Circle");

        //输出原型对象和克隆对象的类型
        System.out.println("Original Appearance Type" + circle.getType());
        System.out.println("Cloned Appearance Type" + clonedCircle.getType());
    }
}
