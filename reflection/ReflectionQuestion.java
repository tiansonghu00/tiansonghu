package com.tian.reflection;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectionQuestion {
    //根据配置文件re.properties指定信息，创建Cat对象并调用hi方法
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        //传统方式 new 对象 -》调用方法
        //Cat cat = new Cat();
        //cat.hi();

        //使用properties类，读写配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\re.properties"));
        String classfullpath = properties.get("classfullpath").toString();
        String methodName = properties.getProperty("method").toString();
        System.out.println("classfullpath=" + classfullpath);
        System.out.println("method=" + methodName);
        //创建对象，传统方法行不通==》反射机制
        //使用反射机制解决
        //1、加载类，返回class类型的对象cls
        Class cls = Class.forName(classfullpath);
        //2、通过cls得到加载的类com.tian.Cat的对象实例
        Object o = cls.newInstance();
        System.out.println("o的运行类型" + o.getClass());
        //3、通过cls得到加载的类com.tian.Cat的methodName"hi"的方法对象
        //即 在反射中，可以把方法是为对象
        Method method1 = cls.getMethod(methodName);
        //4、通过method1的调用方法，即通过方法对象来实现调用方法
        System.out.println("=====================");
        method1.invoke(o);
    }
}
