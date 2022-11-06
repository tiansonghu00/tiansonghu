package com.tian.homework.homework10;

public class Homework10_1 {
    public static void main(String[] args) {
    }
}
class Frock{
    //声明私有静态属性currentNum,初始值100000，作为衣服出厂序列号起始值
    //公有静态方法getNextNum，作为上衣唯一序列号方法，没调用一次，currentNum+100，作为返回值
    //声明serialNumber序列号属性，提供get方法
    //构造器中，调用getNextNum方法获取唯一序列号。赋给serialNumber
    private static int currentNum = 100000;
    private int serialNumber;
    public static int getNextNum() {
        currentNum += 100;
        return currentNum;
    }
    public int getSerialNumber() {
        return serialNumber;
    }
    public Frock() {
        serialNumber = getNextNum();
    }
}
//main方法中调用两次getNextNum，打印输出
//创建3个Frock对象，打印验证
class TestFrock{
    public static void main(String[] args) {
        System.out.println(Frock.getNextNum());
        System.out.println(Frock.getNextNum());
        System.out.println("==========================");
        Frock frock1 = new Frock();
        Frock frock2 = new Frock();
        Frock frock3 = new Frock();
        System.out.println(frock1.getSerialNumber());
        System.out.println(frock2.getSerialNumber());
        System.out.println(frock3.getSerialNumber());
    }
}