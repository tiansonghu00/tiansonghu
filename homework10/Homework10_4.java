package com.tian.homework.homework10;

public class Homework10_4 {
    //编写一个A类，定义局部内部类B，B中有个私有常量name，方法show，打印常量
    //A中也有一个私有变量name，也打印出来
    public static void main(String[] args) {
        A a = new A();
        a.f1();
    }
}
class A {
    private String name = "tom";
    public void f1() {
        class B {
            private final String name = "jack";
            public void show() {
                System.out.println("B= " + name + "A= " + A.this.name);
            }
        }
        B b = new B();
        b.show();
    }
}