package com.tian.transformation;

import java.io.*;

public class InputStreamReader_ {
    //演示使用InputStreamReader转换流解决中文乱码问题,将字节流FileInputStream转成字符流
    public static void main(String[] args) throws IOException {
        String filePath = "e:\\a.txt";
        //new FileInputStream(filePath)转成InputStreamReader
        InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath), "utf-8");
        //把InputStreamReader传入BufferedReader
        BufferedReader br = new BufferedReader(isr);
        //上面两个语句合并
        //BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath),"utf-8"));
        //读取
        String s = br.readLine();
        System.out.println("读取内容=" + s);
        br.close();
    }
}
