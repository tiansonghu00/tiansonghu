package com.tian.homework.homework10;

public class Homework10_3 {
    //计算器接口有work方法，功能是运算，有一个是手机类cellphone，
    //定义方法testWork测试计算功能，调用计算接口的work方法
    //要求调用cellphone对象的testWork方法，使用匿名内部类
    public static void main(String[] args) {
        Cellphone cellphone = new Cellphone();
        cellphone.testWork(new Calculate() {
            @Override
            public double work(double n1, double n2) {
                return n1 + n2;
            }
        },10,8);
    }
}
interface Calculate {
    public double work(double n1,double n2);
}
class Cellphone {
    public void testWork(Calculate calculate,double n1,double n2) {
        double result = calculate.work(n1,n2);
        System.out.println("计算后结果=" + result);
    }
}