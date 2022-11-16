package com.tian;

public class ThreadExit {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.start();
        //希望main线程控制T线程的终止，必须可以修改loop变量
        Thread.sleep(10 * 1000 );
        t.setLoop(false);
    }
}
class T extends Thread {
    private int count = 0;
    //设置控制变量
    private boolean loop = true;
    @Override
    public void run() {
        while (loop) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("TThread 。。。。" + (++count));
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}
