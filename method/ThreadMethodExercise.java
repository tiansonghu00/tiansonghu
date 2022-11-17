package com.tian.method;

public class ThreadMethodExercise {
    //主线程每隔1s，输出hi，一共十次
    //当输出得到hi 5时，启动子线程要求实现Runnable,每隔1s输出hello,输出十次后退出
    //主线程继续输出hi，直到主线程退出
    public static void main(String[] args) throws InterruptedException {
        Thread t2 = new Thread(new T2());
//      T2 t2 = new T2();
//      Thread thread = new Thread(t2);
        for (int i = 0; i <= 10; i++) {
            System.out.println("hi" + i);
            if (i == 5) {
                t2.start();
                t2.join();
//              thread.start();//启动子线程
//              thread.join();
            }
            Thread.sleep(1000);//输出一次hi，让主线程也休眠1s
        }
    }
}
class T2 implements Runnable {
    private int count = 0;
    @Override
    public void run() {
        while (true) {
            System.out.println("hello" + (++count));
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
