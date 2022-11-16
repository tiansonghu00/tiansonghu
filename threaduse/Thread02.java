package com.tian.threaduse;

public class Thread02 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        //不能使用start方法
        Thread thread = new Thread(dog);
        thread.start();
        Tiger tiger = new Tiger();//实现了Runnable接口
        ThreadProxy threadProxy = new ThreadProxy(tiger);
        threadProxy.start();
    }
}
//模拟一个极简的Thread，线程代理类
class ThreadProxy implements Runnable {//把这个类，当作Thread类对待
    private Runnable target = null;
    @Override
    public void run() {
        if (target != null) {
            target.run();//动态绑定(运行类型Tiger)
        }
    }

    public ThreadProxy(Runnable target) {
        this.target = target;
    }
    public void start() {//这个方法是真正实现多线程的方法
        start0();
    }
    public void start0() {
        run();
    }
}
class Animal{}
class Tiger extends Animal implements Runnable {

    @Override
    public void run() {
        System.out.println("老虎叫");
    }
}
class Dog implements Runnable {

    int count = 0;
    @Override
    public void run() {
        while (true) {
            System.out.println("汪汪叫……" + (++count) + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (count == 10) {
                break;
            }
        }
    }
}