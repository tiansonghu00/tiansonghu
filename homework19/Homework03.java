package com.tian.homework19;

import org.junit.Test;

import java.io.*;
import java.util.Properties;

public class Homework03{
    //编写一个dog.properties，编写dog类，创建对象，读取内容完成初始化并输出
    public static void main(String[] args) throws IOException {
//        Properties properties = new Properties();
//        properties.setProperty("name","tom");
//        properties.setProperty("age","5");
//        properties.setProperty("color","red");
//        properties.store(new FileOutputStream("src\\dog.properties"),null);
        String filePath = "src\\dog.properties";
        Properties properties = new Properties();
        properties.load(new FileReader(filePath));
        String name = properties.getProperty("name") + "";
        int age = Integer.parseInt(properties.getProperty("age") + "");
        String color = properties.getProperty("color") + "";
        Dog dog = new Dog(name,age,color);
        System.out.println("对象信息");
        System.out.println(dog);
        //序列化
        String serFilePath = "e:\\dog.dat";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(serFilePath));
        oos.writeObject(dog);
        oos.close();
        System.out.println("完成序列化");
    }
    //编写一个方法，反序列化
    @Test
    public void m1() throws IOException, ClassNotFoundException {
        String serFilePath = "e:\\dog.dat";
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(serFilePath));
        Dog dog = (Dog) objectInputStream.readObject();
        System.out.println("反序列化");
        System.out.println(dog);
        objectInputStream.close();
    }
}
class Dog implements Serializable{
    private String name;
    private int age;
    private String color;

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
