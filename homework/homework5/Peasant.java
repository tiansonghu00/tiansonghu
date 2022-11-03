package com.tian.homework.homework5;

public class Peasant extends Employee{
    public Peasant(String name, double salary) {
        super(name, salary);
    }

    @Override
    public void printSal() {
        System.out.println("农民 ");
        super.printSal();
    }
}
