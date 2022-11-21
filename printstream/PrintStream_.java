package com.tian.printstream;

import java.io.IOException;
import java.io.PrintStream;

public class PrintStream_ {
    //演示PrintStream字节打印流
    public static void main(String[] args) throws IOException {
        PrintStream out = System.out;
        //默认情况下，输出位置是标准输出，即显示器
        out.println("jack,tom");//底层就是用的write
        out.write("jack".getBytes());
        out.close();
        System.setOut(new PrintStream("e:\\c.txt"));
        System.out.println("hello");
    }
}
