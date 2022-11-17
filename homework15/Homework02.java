package com.tian.homework15;

public class Homework02 {
    //有两个用户分别从同一个卡取钱，每次都取1000，钱不够就不能取款了，也不能出现超取
    public static void main(String[] args) {
        WithDraw withDraw = new WithDraw();
        Thread thread1 = new Thread(withDraw);
        thread1.setName("jack");
        Thread thread2 = new Thread(withDraw);
        thread2.setName("tom");
        thread1.start();
        thread2.start();
    }
}
class WithDraw implements Runnable {
    private int money = 10000;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (money < 1000) {
                    System.out.println("余额不足");
                    break;
                }
                money -= 1000;
                System.out.println(Thread.currentThread().getName() + "取了一千块，当前余额" + money);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}