package com.tian.homework.homework5;
public class Homework05 {
    public static void main(String[] args) {
        //打印各职业年薪
        Worker worker = new Worker("aa",2000);
        worker.printSal();

        Peasant peasant =new Peasant("bb",3000);
        peasant.printSal();

        Teacher teacher = new Teacher("cc",4000);
        teacher.setClassSal(50);
        teacher.setClassDays(20);
        teacher.printSal();

        Scientist scientist = new Scientist("dd",5000);
        scientist.setBonus(10000);
        scientist.printSal();

        Waiter waiter = new Waiter("ee",3500);
        waiter.printSal();
    }
}
