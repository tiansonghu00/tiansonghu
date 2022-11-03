package com.tian.homework.homework4;

public class Homework04 {
    public static void main(String[] args) {
        Manager manager = new Manager("jack",200,26,1.2);
        //设置经理奖金
        manager.setBonus(4000);
        manager.printSal();
        Staff staff = new Staff("tom",150,30,1.0);
        staff.printSal();
    }
}
