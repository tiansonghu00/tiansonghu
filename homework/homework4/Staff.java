package com.tian.homework.homework4;

public class Staff extends Employee {
    //普通员工工资=单日*天数*等级

    public Staff(String name, double daySal, int workDays, double grade) {
        super(name, daySal, workDays, grade);
    }
    public void printSal() {
        System.out.print("普通员工");
        super.printSal();
    }
}
