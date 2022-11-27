package com.tian.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectCreateInstance {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class userClass = Class.forName("com.tian.reflection.User");
        //通过public无参构造器创建实例
        Object o = userClass.newInstance();
        System.out.println(o);
        //通过public有参构造器创建实例
        Constructor constructor = userClass.getConstructor(String.class);
        Object jack = constructor.newInstance("jack");
        System.out.println(jack);
        //通过非public的有参构造器创建实例
        Constructor constructor1 = userClass.getDeclaredConstructor(int.class,String.class);
        constructor1.setAccessible(true);//使用反射，访问私有构造器
        Object mali = constructor1.newInstance(100, "mali");
    }
}
class User{
    private int age = 1;
    private String name = "tom";
    public User() {

    }

    public User(String name) {
        this.name = name;
    }

    private User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}