package com.tian.syn;

public class SellTicket1 {
    //售票100张
    public static void main(String[] args) {
        SellTicket03 sellTicket03 = new SellTicket03();
        new Thread(sellTicket03).start();
        new Thread(sellTicket03).start();
        new Thread(sellTicket03).start();
    }
}
//实现接口方法,使用synchronized来实现线程同步
class SellTicket03 implements Runnable {
    private int tickNum = 100;
    private boolean loop = true;//控制run方法
    public synchronized void sell() {//同步方法
        if (tickNum <= 0) {
            System.out.println("售票结束……");
            loop = false;
            return;
        }
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("窗口" + Thread.currentThread().getName() + "售出一张票" + "剩余票数=" + (--tickNum));
    }
    @Override
    public void run() {
        while (loop) {
            sell();
        }
    }
}
//使用Thread方式
class SellTicket01 extends Thread {
    private static int tickNum = 100;//让多个线程共享

    @Override
    public void run() {
        while (true) {
            if (tickNum <= 0) {
                System.out.println("售票结束……");
                break;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("窗口" + Thread.currentThread().getName() + "售出一张票" + "剩余票数=" + (--tickNum));
        }
    }
}
//实现接口方法
class SellTicket02 implements Runnable {
    private int tickNum = 100;

    @Override
    public void run() {
        while (true) {
            if (tickNum <= 0) {
                System.out.println("售票结束……");
                break;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("窗口" + Thread.currentThread().getName() + "售出一张票" + "剩余票数=" + (--tickNum));
        }
    }
}