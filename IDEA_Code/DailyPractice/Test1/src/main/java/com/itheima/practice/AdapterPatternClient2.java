package com.itheima.practice;

//目标接口： 美国插头
interface USPlug {
    void connect();
}

//支持美国插头的设备
class USDevice implements USPlug {
    @Override
    public void connect() {
        System.out.println("Connected to US power outlet.");
    }
}

//源接口: 欧洲插头
interface EUPlug {
    void connect();
}

//欧洲插头实现类
class EUPlugImpl implements EUPlug {
    @Override
    public void connect() {
        System.out.println("Connected to EU power outlet.");
    }
}

//适配器类，将欧洲插头适配为美国插头
class EUToUSAdapter implements USPlug {
    private EUPlug euPlug;

    public EUToUSAdapter(EUPlug euPlug) {
        this.euPlug = euPlug;
    }

    @Override
    public void connect() {
        euPlug.connect(); //调用欧洲插头的连接方法
        System.out.println("Adapted to US power outlet.");
    }
}

public class AdapterPatternClient2 {
    public static void main(String[] args) {
        // 创建美国设备
        USDevice usDevice = new USDevice();
        usDevice.connect(); // 直接连接

        // 创建欧洲插头
        EUPlug euPlug = new EUPlugImpl();
        EUToUSAdapter adapter = new EUToUSAdapter(euPlug);
        adapter.connect(); // 使用适配器连接  
    }
}
