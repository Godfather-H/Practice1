package design_patterns;

import java.util.HashMap;
import java.util.Map;

enum Colors{RED, GREEN, BLUE, YELLOW}

//享元接口
interface Configuration {
    void draw(int x, int y);
}

//具体享元类
class Cone implements Configuration {
    private Colors color;

    public Cone(Colors color) {
        this.color = color;
    }

    @Override
    public void draw(int x, int y) {
        System.out.println("Drawing a " + color + "cone at (" + x + "," + y + ")");
    }
}

//享元工厂类
class ConfigurationFactory {
    private static final Map<Colors, Configuration> coneMap = new HashMap<>();

    public static Configuration getCone(Colors color){
        Configuration cone = coneMap.get(color);

        if(cone == null){
            cone = new Cone(color);
            coneMap.put(color, cone);
        }

        return cone;
    }
}

//在这个示例中，我们定义了一个Shape接口和一个具体的Circle类来表示享元对象。
//ShapeFactory类负责管理共享的对象池，并通过getCircle方法返回共享的或新创建的原型对象。
//在main函数中，我们随机选择不同的颜色，并使用ShapeFactory获取对应的圆形对象，然后调用draw方法绘制它们。
public class FlyweightPatternExample {
    public static void main(String[] args) {
        Colors[] colors = {Colors.RED, Colors.GREEN, Colors.BLUE, Colors.YELLOW};
        for(int i = 0; i < 20; i++){
            Colors randomColor = colors[(int) (Math.random() * colors.length)];
            Configuration cone = ConfigurationFactory.getCone(randomColor);
            cone.draw((int)(Math.random() * 100), (int) (Math.random() * 100));
        }
    }
}
