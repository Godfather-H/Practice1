package design_patterns;

class Singleton{
    //保存唯一实例的静态变量
    private static volatile Singleton instance;

    //私有构造方法，防止外部实例化
    private Singleton(){
        //初始化操作
    }

    //公共静态方法，用于获取单例
    public static Singleton getInstance(){
        if(instance == null){
            //如果实例为空，则创建一个新实例
            synchronized(Singleton.class){
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
    //其他成员方法
    public void showMessage(){
        System.out.println("Hello, I am Singleton!");
    }

}
//这个示例演示了如何创建一个简单的单例模式
public class SingletonExample {
    public static void main(String[] args) {
        //获取单例实例
        Singleton singleton = Singleton.getInstance();
        //调用成员方法
        singleton.showMessage();
    }
}
