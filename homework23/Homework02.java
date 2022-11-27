package com.tian.homework23;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Homework02 {
    //利用class类的forname方法，得到file类的class对象，在控制台打印所有file类构造器
    //通过newInstance的方法创建file对象，并创建E盘的mynew.txt
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> fileClass = Class.forName("java.io.File");
        //得到所有的构造器
        Constructor<?>[] declaredConstructors = fileClass.getDeclaredConstructors();
        //遍历输出
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }
        //指定的得到public java.io.File
        Constructor<?> declaredConstructor = fileClass.getDeclaredConstructor(String.class);
        String filePath = "e:\\mynew.txt";
        Object file = declaredConstructor.newInstance(filePath);
        //得到createNewFile 的方法对象
        Method createNewFile = fileClass.getMethod("createNewFile");
        createNewFile.invoke(file);
        //file运行类型就是File
        System.out.println(file.getClass());
        System.out.println("创建成功" + filePath);
    }
}
