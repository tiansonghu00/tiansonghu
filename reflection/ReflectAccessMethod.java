package com.tian.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectAccessMethod {
    //演示通过反射调用方法
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> bossClass = Class.forName("com.tian.reflection.Boss");
        //创建对象
        Object o = bossClass.newInstance();
        //调用public的hi方法
        //Method hi = bossClass.getMethod("hi");
        Method hi = bossClass.getDeclaredMethod("hi",String.class);
        //调用
        hi.invoke(o,"jack");
        //调用say方法
        Method say = bossClass.getDeclaredMethod("say", int.class, String.class, char.class);
        say.setAccessible(true);
        System.out.println(say.invoke(o,1,"tom",'a'));
        System.out.println(say.invoke(null,2,"asd",'v'));
        //在反射中，如果方法有返回值，统一返回Object
        Object reVal = say.invoke(null,500,"张三",'女');
        System.out.println("return" + reVal.getClass());//运行类型和方法中的定义一致
        System.out.println(reVal);
    }
}
class Boss {
    public int age;
    private static String name;

    public Boss() {
    }
    private static String say(int n,String s,char c) {
        return n + " " + s + " " + c;
    }

    public void hi(String s) {
        System.out.println("hi" + s);
    }
}