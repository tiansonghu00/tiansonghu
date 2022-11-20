package com.tian.buffered;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriter_ {
    public static void main(String[] args) throws IOException {
        String filePath = "e:\\ok.txt";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath,true));
        bufferedWriter.write("hello,你好");
        //插入一个换行
        bufferedWriter.newLine();
        bufferedWriter.write("hello,你好");
        bufferedWriter.write('\n');
        //关闭外层流即可
        bufferedWriter.close();
    }
}
