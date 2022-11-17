package com.tian.method;

public class ThreadMethod02 {
    public static void main(String[] args) throws InterruptedException {
//测试如何将一个线程设置成守护线程
        MyDaemonThread myDaemonThread = new MyDaemonThread();
        //如果希望主线程结束时，子线程可以自动结束,只要把子线程设为守护线程就行
        myDaemonThread.setDaemon(true);
        myDaemonThread.start();//先设置守护再启动线程
        for (int i = 0; i <= 10; i++) {
            System.out.println("hello");
            Thread.sleep(1000);
        }
    }
}
class MyDaemonThread extends Thread {//Daemon守护线程
    @Override
    public void run() {
        for (; ; ) {//无线循环
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("hhhhhhh");
        }
    }
}
