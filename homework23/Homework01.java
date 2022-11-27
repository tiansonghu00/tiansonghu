package com.tian.homework23;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Homework01 {
    //定义PrivateTest类，有私有name，属性值为hello，提供get公有方法
    //创建PrivateTest类，利用class类得到name属性，修改属性值，调用getName方法输出
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        Class<?> aClass = Class.forName("com.tian.homework23.PrivateTest");
        //创建对象实例
        Object o = aClass.newInstance();
        //得到name属性对象
        Field field = aClass.getDeclaredField("name");
        //爆破
        field.setAccessible(true);
        field.set(o,"jack");
        //得到getName方法对象
        Method getName = aClass.getMethod("getName");
        //因为是public，直接调用
        Object invoke = getName.invoke(o);
        System.out.println(invoke);
    }
}
class PrivateTest {
    private String name = "hello";

    public String getName() {
        return name;
    }
}