package com.tian.homework.homework5;

public class Employee {
    //子类工人worker,农民peasant，教师类teacher。科学家类scientist.服务生类waiter
    //工人，农民，服务生只有基本工资，教师额外有课酬（元/天），科学家额外有年终奖
    private String name;
    private double salary;
    private int salMonth = 12;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getSalMonth() {
        return salMonth;
    }

    public void setSalMonth(int salMonth) {
        this.salMonth = salMonth;
    }
    public void printSal() {
        System.out.println("name=" + name + "工资=" + (salary * salMonth));
    }
}
