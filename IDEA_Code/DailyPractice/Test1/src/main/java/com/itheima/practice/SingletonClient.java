package com.itheima.practice;

class Singleton {
    //使用volatile关键之保证多线程下对instance的可见性
    private static volatile Singleton instance;

    //私有构造函数，防止外部实例化
    private Singleton() {
    }

    //提供全局访问点
    public static Singleton getInstance() {
        //第一次检查，如果为null则进入同步块
        if(instance == null) {
            synchronized (Singleton.class) {
                //第二次检查，在同步块中再次检查
                if(instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}

public class SingletonClient {
    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();

        System.out.println(instance1 == instance2);
    }
}
