package com.tian.homework.homework4;

public class Manager extends Employee{
    //部门经理工资=1000+单日*天数*等级1.2==>奖金+工资
    private double bonus;
    //奖金不确定，因此构造器中不加奖金
    public Manager(String name, double daySal, int workDays, double grade) {
        super(name, daySal, workDays, grade);
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
    public void printSal() {
        System.out.println("经理" + getName() + "工资="
                + (bonus + getDaySal() * getWorkDays() * getGrade()));
    }
}
