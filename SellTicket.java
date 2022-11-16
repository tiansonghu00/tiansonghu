package com.tian;

public class SellTicket {
    //售票100张
    public static void main(String[] args) {
        SellTicket01 sellTicket01 = new SellTicket01();
        sellTicket01.start();
        SellTicket02 sellTicket02 = new SellTicket02();
        Thread thread = new Thread(sellTicket02);
        thread.start();
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