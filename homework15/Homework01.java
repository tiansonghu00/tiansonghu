package com.tian.homework15;

import java.util.Scanner;

public class Homework01 {
    //在main方法中启动两个线程，第一个循环随机打印100以内整数，直到第二个从键盘读取了Q命令
    public static void main(String[] args) {
        A a = new A();
        B b = new B(a);
        a.start();
        b.start();
    }
}
class A extends Thread {
    private boolean loop = true;

    @Override
    public void run() {
        while (loop) {
            System.out.println((int) (Math.random() * 100 + 1));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setLoop(boolean loop) {//用来修改loop
        this.loop = loop;
    }
}
class B extends Thread {
    private A a;
    private Scanner scanner = new Scanner(System.in);
    public B(A a) {//构造器,直接传入A类对象
        this.a = a;
    }
    @Override
    public void run() {
        while (true) {
            System.out.println("输入Q退出");
            char key = scanner.next().toUpperCase().charAt(0);
            if (key == 'Q') {
                //以通知的方式结束A线程
                a.setLoop(false);
                System.out.println("B线程退出");
                break;
            }
        }
    }
}