package com.tian.class_;

import java.lang.reflect.Field;

public class Class01 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        //演示class类常用方法
        String classAllPath = "com.tian.class_.Car";
        //获取到Car对应的class对象
        //<?> 表示不确定得到java类型
        Class<?> cls = Class.forName(classAllPath);
        //输出cls
        System.out.println(cls);//显示cls对象，是哪个类的class对象，
        System.out.println(cls.getClass());//输出cls运行类型
        //得到包名
        System.out.println(cls.getPackage().getName());
        //得到全类名
        System.out.println(cls.getName());
        //通过cls创建对象实例
        Car car = (Car) cls.newInstance();
        System.out.println(car);//car.toString
        //通过反射获取属性
        Field brand = cls.getField("brand");
        System.out.println(brand.get(car));//私有属性会报错
        //通过反射，给属性赋值
        brand.set(car,"奔驰");
        System.out.println(brand.get(car));
        //可以得到所有属性
        System.out.println("============================");
        Field[] fields = cls.getFields();
        for (Field field :fields) {
            System.out.println(field.getName());
        }

    }
}
