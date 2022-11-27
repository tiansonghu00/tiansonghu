package com.tian.reflection;

import java.lang.reflect.Field;

public class ReflectAccessProperty {
    //演示反射操作属性
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<?> stuClass = Class.forName("com.tian.reflection.Student");
        //创建对象
        Object o = stuClass.newInstance();//o的运行类型就是student
        System.out.println(o.getClass());
        //使用反射得到age属性对象
        Field age = stuClass.getField("age");
        age.set(o,20);
        System.out.println(o);
        System.out.println(age.get(o));
        //使用反射操作name属性
        Field name = stuClass.getDeclaredField("name");
        name.setAccessible(true);
        //name.set(o,"jack");
        name.set(null,"jack");
        System.out.println(o);
        System.out.println(name.get(null));//要求name是静态的
    }
}
class Student {
    public int age;
    private static String name;

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age + ","
                + "name=" + name
                + '}';
    }
}