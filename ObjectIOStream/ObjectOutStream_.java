package com.tian.ObjectIOStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectOutStream_ {
    public static void main(String[] args) throws Exception {
        //演示ObjectOutputStream使用，完成数据序列化
        //序列化后，保存的文件格式不是文本，而是按照他的格式来保存
        String filePath = "e:\\data.dat";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
        oos.writeInt(120);//int ->Integer(实现了Serializable）
        oos.writeBoolean(true);//boolean -》Boolean
        oos.writeChar('a');//char ->Character
        oos.writeDouble(2.6);//double ->Double
        oos.writeUTF("你好");
        //保存一个对象
        oos.writeObject(new Dog("大黄",5));
        oos.close();
        System.out.println("数据保存完毕");
    }
}
    class Dog implements Serializable {
        private String name;
        private int age;

        public Dog(String name, int age) {
            this.name = name;
            this.age = age;
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

        @Override
        public String toString() {
            return "Dog{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
