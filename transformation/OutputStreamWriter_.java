package com.tian.transformation;

import java.io.*;

public class OutputStreamWriter_ {
    public static void main(String[] args) throws IOException {
        //演示使用OutputStreamWriter转换流解决中文乱码问题,将字节流FileOutputStream转成字符流OutputStreamWriter,指定编码
        String filePath = "e:\\b.txt";
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(filePath,true), "utf-8");
        osw.write("hello,你好！");
        osw.close();
        System.out.println("文件保存成功");
    }
}
