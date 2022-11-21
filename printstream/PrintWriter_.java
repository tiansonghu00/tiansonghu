package com.tian.printstream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriter_ {
    //演示PrintWriter使用方法
    public static void main(String[] args) throws IOException {
        PrintWriter printWriter = new PrintWriter(System.out);
        printWriter.print("hello,你好");
        printWriter.close();
        PrintWriter printWriter1 = new PrintWriter(new FileWriter("e:\\d.txt"));
        printWriter1.print("hi,你好");
        printWriter1.close();
        PrintWriter printWriter2 = new PrintWriter(new FileWriter("e:\\e.txt"));
        printWriter2.print("hi,你好");
        printWriter2.close();
    }

}
