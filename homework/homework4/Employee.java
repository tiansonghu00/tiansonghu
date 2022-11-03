package com.tian.homework.homework4;

public class Employee {
    //属性姓名，日薪，工作天数，员工方法（打印工资），普通员工和经理要重写打印方法
    //定义初始化对象，并打印输出
    private String name;
    private double daySal;
    private int workDays;
    private double grade;

    public Employee(String name, double daySal, int workDays, double grade) {
        this.name = name;
        this.daySal = daySal;
        this.workDays = workDays;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDaySal() {
        return daySal;
    }

    public void setDaySal(double daySal) {
        this.daySal = daySal;
    }

    public int getWorkDays() {
        return workDays;
    }

    public void setWorkDays(int workDays) {
        this.workDays = workDays;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
    public void printSal() {
        System.out.println(name + "工资=" + daySal * workDays * grade);
    }
}
