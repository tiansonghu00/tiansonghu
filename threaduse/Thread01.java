package com.tian.threaduse;

public class Thread01 {
    public static void main(String[] args) throws InterruptedException {
        Cat cat = new Cat();
        cat.start();//启动线程
        //当main线程启动一个子线程Thread-0,主线程不会阻塞，会继续执行
        System.out.println("主线程继续执行" + Thread.currentThread().getName());
        for (int i = 0; i < 10; i++) {
            System.out.println("主线程" + i);
            Thread.sleep(1000);
        }
    }
}
class Cat extends Thread {//该类就可以当作线程使用
    //run Thread类实现了Runnable接口的run方法    @Override
    /*    public void run() {
            if (target != null) {
                target.run();
            }
        }
    */
    int times = 0;
    @Override
    public void run() {
        //重写run方法，写上自己的业务逻辑
        //每隔一秒，输出喵喵我是小猫
        while (true) {
            System.out.println("喵喵，我是小猫咪" + (++times) + "线程名" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);//休眠1s
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (times == 8) {
                break;
            }
        }
    }
}