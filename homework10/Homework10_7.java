package com.tian.homework.homework10;

public class Homework10_7 {
    //创建一个color枚举类，有red，blue，black，yellow，green五个枚举值
    //color有三个属性redValue，greenValue，blueValue，
    //创建构造方法，参数包括这三个属性，每个枚举值都要给这三个赋值
    //red=255,0,0，blue0,0,255，black0,0,0，，yellow,255,255,0，green0,255,0
    //定义接口，里面有show方法，要求color实现该接口
    //show方法中显示三属性的值，将枚举对象在Switch中匹配使用
    public static void main(String[] args) {
        Color GREEN = Color.green;
        GREEN.show();
        switch (GREEN) {
            case red:
                System.out.println("匹配到红色");
                break;
            case blue:
                System.out.println("匹配到蓝色");
                break;
            case yellow:
                System.out.println("匹配到黄色");
                break;
            default:
                System.out.println("没找到");
        }
    }
}
enum Color implements MyColor{
    red(255,0,0),blue(0,0,255),
    black(0,0,0),yellow(255,255,0),green(0,255,0);
    private int redValue;
    private int greenValue;
    private int blueValue;

    Color(int redValue, int greenValue, int blueValue) {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }

    @Override
    public void show() {
        System.out.println("属性值为"+ redValue + "," + greenValue + "," + blueValue);
    }
}
interface MyColor {
    public void show();
}