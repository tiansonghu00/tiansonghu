package com.tian.method;

public class ThreadMethod {
    public static void main(String[] args) throws InterruptedException {
        T1 t1 = new T1();
        t1.start();
        for (int i = 0; i <= 20; i++) {
            Thread.sleep(1000);
            System.out.println("主线程吃了" + i + "包子");
            if (i == 5) {
                System.out.println("主线程让子线程先吃");
                t1.join();//相当于先让t1执行完毕
                System.out.println("子线程吃完了，主线程接着吃");
            }
        }
    }
}
class T1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <= 20; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("子线程吃了------" + i + "包子");
        }
    }
}