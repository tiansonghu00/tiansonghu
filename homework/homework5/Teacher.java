package com.tian.homework.homework5;

public class Teacher extends Employee{
    private int classDays;
    private double classSal;

    public Teacher(String name, double salary) {
        super(name, salary);
    }

    public int getClassDays() {
        return classDays;
    }

    public void setClassDays(int classDays) {
        this.classDays = classDays;
    }

    public double getClassSal() {
        return classSal;
    }

    public void setClassSal(double classSal) {
        this.classSal = classSal;
    }

    @Override
    public void printSal() {
        System.out.println("老师 ");
        System.out.println(getName() + "年薪="
                + (getSalary() * getSalMonth() + classSal * classDays));
    }
}
