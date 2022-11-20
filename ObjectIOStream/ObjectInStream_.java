package com.tian.ObjectIOStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInStream_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String filePath = "e:\\data.dat";
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));
        //反序列化顺序要和序列化保存的顺序一致
        System.out.println(ois.readInt());
        System.out.println(ois.readBoolean());
        System.out.println(ois.readChar());
        System.out.println(ois.readDouble());
        System.out.println(ois.readUTF());
        //读取狗对象
        Object dog = ois.readObject();
        System.out.println("运行类型=" + dog.getClass());
        System.out.println("dog=" + dog);
        //如果希望调用Dog的方法，需要向下转型
        Dog dog1 = (Dog)dog;
        System.out.println(dog1.getName());
        ois.close();

    }
}
