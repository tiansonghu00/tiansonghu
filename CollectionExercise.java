package com.tian;

import java.util.ArrayList;
import java.util.Iterator;

public class CollectionExercise {
    //创建三个DOG对象，有名字，年龄，放入ArrayList中，赋给List引用
    //用迭代器和增强for两种方式遍历，重写toString，输出
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(new Dog("大黄", 6));
        list.add(new Dog("大壮", 7));
        list.add(new Dog("小白", 4));
        //for增强
        for (Object dog : list) {
            System.out.println(dog);
        }
        //迭代器
        System.out.println("==================");
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object dog =  iterator.next();
            System.out.println(dog);
        }
    }
}
class Dog {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
