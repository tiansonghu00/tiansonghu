package com.tian.class_;

public class Car {
    public String brand = "宝马";
    public int price = 100000;
    public String color = "黑色";

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}
