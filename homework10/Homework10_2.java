package com.tian.homework.homework10;

public class Homework10_2 {
    //动物类animal包含抽象方法shout()；
    //cat类继承动物，实现方法，打印叫声；狗也一样
    //测试类中，实例化Animal cat = new Cat(),调用shout方法
    public static void main(String[] args) {
        Animal cat = new Cat();
        cat.shout();
        Animal dog = new Dog();
        dog.shout();
    }
}
abstract class Animal {
    public abstract void shout();
}
class Cat extends Animal {
    @Override
    public void shout() {
        System.out.println("喵喵叫");
    }
}
class Dog extends Animal {
    @Override
    public void shout() {
        System.out.println("汪汪叫");
    }
}
