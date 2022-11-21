package com.tian.homework19;

import java.io.*;

public class Homework02 {
    public static void main(String[] args) throws IOException {
        //使用BufferedReader读取一个文本文件，为每行加上行号，连同内容输出到屏幕上
        String filePath = "e:\\a.txt";
        int count = 0;
        String line = "";
        BufferedReader bfr = new BufferedReader(new InputStreamReader(new FileInputStream(filePath),"utf8"));
        while ((line = bfr.readLine()) != null) {
            System.out.println(++count+ "行号" + line);
        }
        if (bfr != null) {
            bfr.close();
        }
    }
}
