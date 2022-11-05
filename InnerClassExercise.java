package com.tian;

public class InnerClassExercise {
    //有一个铃声接口Bell,里面有个ring方法
    //有一个手机类Cellphone,就有闹钟功能alarmclock，参数是Bell
    //测试手机类的闹钟功能，通过匿名内部类作为参数，打印起床了
    //再传入一个匿名内部类，打印上课了
    public static void main(String[] args) {

        CellPhone cellPhone = new CellPhone();

        cellPhone.alarmclock(new Bell() {
            @Override
            public void ring() {
                System.out.println("起床了");
            }
        });
        cellPhone.alarmclock(new Bell() {
            @Override
            public void ring() {
                System.out.println("上课了");
            }
        });
    }
}
interface Bell{
    void ring();
}
class CellPhone{
    public void alarmclock(Bell bell) {
            bell.ring();
    }
}
