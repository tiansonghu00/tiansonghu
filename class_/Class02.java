package com.tian.class_;

public class Class02 {
    //演示得到class对象的各种方法
    public static void main(String[] args) throws ClassNotFoundException {
        //1.class.forName
        String classAllPath = "com.tian.class_.Car";//通过读取配置文件获取
        Class cls1 = Class.forName(classAllPath);
        System.out.println(cls1);
        //2.类名.class，用于参数传递
        Class cls2 = Car.class;
        System.out.println(cls2);
        //3.对象.getClass()，用于有对象实例的
        Car car = new Car();
        Class cls3 = car.getClass();
        System.out.println(cls3);
        //4.通过类加载器来获取类的class对象
        //先得到类加载器
        ClassLoader classLoader = car.getClass().getClassLoader();
        //通过类加载器得到class对象
        Class cls4 = classLoader.loadClass(classAllPath);
        System.out.println(cls4);
        //5.基本数据类型，按如下方法得到class类对象
        Class<Integer> integerClass = int.class;
        Class<Boolean> booleanClass = boolean.class;
        System.out.println(integerClass);
        System.out.println(booleanClass);
        //6.基本数据类型对应的包装类，通过.TYPE来得到class类对象
        Class<Integer> type1 = Integer.TYPE;
        Class<Character> type2 = Character.TYPE;
        System.out.println(type1);
        System.out.println(type2);
    }


}
