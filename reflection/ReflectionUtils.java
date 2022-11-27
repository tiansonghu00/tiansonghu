package com.tian.reflection;

import org.testng.annotations.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionUtils {
    public static void main(String[] args) {
        //演示如何通过反射，获取类的结构信息
    }
    //第一组方法API
    @Test
    public void api_01() throws ClassNotFoundException {
        Class personCls = Class.forName("com.tian.reflection.Person");
        //1. getName:获取全类名
        System.out.println(personCls.getName());
        //2. getSimpleName:获取简单类名
        System.out.println(personCls.getSimpleName());
        //3.getFields:获取所有public修饰的属性,包含本类以及父类的
        Field[] fields = personCls.getFields();
        for (Field field : fields) {
            System.out.println("本类以及父类的属性" + field.getName());
        }
        //4.getDeclaredFields:获取本类中所有属性
        Field[] declaredFields = personCls.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("本类中所有属性" + declaredField.getName());
        }
        //5. getMethods:获取所有public集资额方法,包含本类以及父类的方法
        Method[] methods = personCls.getMethods();
        for (Method method : methods) {
            System.out.println("本类以及父类的方法" + method.getName());
        }
        //6.getDeclaredMethods获取本类中所有方法
        Method[] declaredMethods = personCls.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("本类中所有方法" + declaredMethod.getName());
        }
        //7. getConstructors:获取所有public修饰的构造器，包含本类
        Constructor[] constructors = personCls.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("本类构造器" + constructor.getName());
        }
        //8.getDeclaredConstructors:取本类中所有构造器
        Constructor[] declaredConstructors = personCls.getDeclaredConstructors();
        for (Constructor declaredConstructor : declaredConstructors) {
            System.out.println("本类中所有构造器" + declaredConstructor.getName());
        }
        //9.getPackage:以Package形式遇回包信息
        System.out.println(personCls.getPackage());
        //10.getSuperClass:以Class形式运回文类信息
        Class superclass = personCls.getSuperclass();
        System.out.println(superclass);
        //11.getInterfaces:以Class[]形式返回接口信息
        Class[] interfaces = personCls.getInterfaces();
        for (Class anInterface : interfaces) {
            System.out.println("接口信息" + anInterface);
        }
        //12.getAnnotations:以Annotation[]形式返回注解信息
        Annotation[] annotations = personCls.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("注解信息" + annotation);
        }
    }
    @Test
    public void api_02 () throws ClassNotFoundException {
        Class personCls = Class.forName("com.tian.reflection.Person");
        //getDeclaredFields:获取本类中所有属性
        Field[] declaredFields = personCls.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            //默认修饰符是0，public是1，private是2，protect是4，static是8，final是16
            System.out.println("本类中所有属性" + declaredField.getName() + "该属性的修饰符值=" +declaredField.getModifiers()
                    + "该属性的类型" + declaredField.getType());
        }
        //getDeclaredMethods获取本类中所有方法
        Method[] declaredMethods = personCls.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("本类中所有方法" + declaredMethod.getName() + "方法的访问修饰符值=" + declaredMethod.getModifiers()
                    + "方法返回类型" + declaredMethod.getReturnType());
            //输出当前方法的形参数组
            Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
            for (Class parameterType : parameterTypes) {
                System.out.println("该方法的形参类型" + parameterType);
            }
        }
        //getDeclaredConstructors:取本类中所有构造器
        Constructor[] declaredConstructors = personCls.getDeclaredConstructors();
        for (Constructor declaredConstructor : declaredConstructors) {
            System.out.println("本类中所有构造器" + declaredConstructor.getName());
            Class[] parameterTypes = declaredConstructor.getParameterTypes();
            for (Class parameterType : parameterTypes) {
                System.out.println("该构造器的形参类型=" + parameterType);
            }
        }

    }
}
class A {
    public String hobby;
    public void hi() {

    }

    public A() {
    }
}
interface IA {

}
interface IB {

}
@Deprecated
class Person extends A implements IA,IB{
    public String name;
    protected int age;
    String job;
    private double sal;

    public Person() {
    }
    public Person(String name) {

    }
    private Person(String name,int age) {

    }
    public void m1() {

    }
    protected void m2() {

    }
    void m3() {

    }
    private void m4() {

    }
}
