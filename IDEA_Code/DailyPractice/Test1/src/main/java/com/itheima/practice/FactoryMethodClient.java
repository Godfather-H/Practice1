package com.itheima.practice;

//产品接口
interface Car {
    void drive();
}

//具体产品: 宝马车
class BMW implements Car {
    @Override
    public void drive() {
        System.out.println("Driving a BMW!");
    }
}

//具体产品: 奔驰车
class Mercedes implements Car {

    @Override
    public void drive() {
        System.out.println("Driving a Mercedes!");
    }
}

//工厂类
class CarFactory {
    public static Car createCar(String carType) {
        if (carType.equals("BMW")) {
            return new BMW();
        } else if (carType.equals("Mercedes")) {
            return new Mercedes();
        }
        return null;
    }
}

public class FactoryMethodClient {
    public static void main(String[] args) {
        Car car1 = CarFactory.createCar("BMW");
        Car car2 = CarFactory.createCar("Mercedes");

        car1.drive();
        car2.drive();
    }
}
