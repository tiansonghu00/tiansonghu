package com.tian.homework.homework10;

public class Homework_6 {
    //有一个car类，有属性temperature温度，车里有Air空调类，出风功能flow，
    //空调会监视车内温度，40度以上冷风，低于0度热风，否则关闭空调
    //实例化具有不同温度的car对象，调用空调的flow方法，成员内部类
    public static void main(String[] args) {
        Car car1 = new Car(45.0);
        car1.getAir().flow();
        Car car2 = new Car(5.0);
        car2.getAir().flow();
        Car car3 = new Car(-5.0);
        car3.getAir().flow();
    }
}
class Car{
    private double temperature;

    public Car(double temperature) {
        this.temperature = temperature;
    }

    class Air {
        public void flow() {
            if (temperature > 40.0) {
                System.out.println("吹冷风");
            } else if (temperature < 0 ) {
                System.out.println("吹热风");
            } else {
                System.out.println("空调自动关闭");
            }
        }
    }
    public Air getAir() {
        return new Air();
    }
}
