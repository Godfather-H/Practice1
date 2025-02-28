package com.itheima.practice;

//主题接口
interface Image {
    void display();
}

//真实主题类
class RealImage implements Image {
    private final String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadImageFromDisk(); //在创建时加载图像
    }

    private void loadImageFromDisk() {
        System.out.println("Loading " + filename);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + filename);
    }
}

//代理类
class ProxyImage implements Image {
    private final String filename;
    private RealImage realImage;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        //只有在需要时才加载图像
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}


public class ProxyClient {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("photo1.jpg");
        Image image2 = new ProxyImage("photo2.jpg");

        //不会立即加载图像
        image1.display(); //第一次调用加载图像
        image1.display(); //不会加载图像，直接显示

        //另一张图像
        image2.display(); // 第一次调用会加载图像

    }
}
