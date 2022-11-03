package com.tian.homework.homework5;

public class Scientist extends Employee{
    private double bonus;

    public Scientist(String name, double salary) {
        super(name, salary);
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public void printSal() {
        System.out.println("科学家");
        System.out.println(getName() + "年薪=" + (getSalary() * getSalMonth() + bonus));
    }
}
