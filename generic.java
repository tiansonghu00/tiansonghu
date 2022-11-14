package com.tian;

import java.util.ArrayList;
import java.util.Comparator;

public class generic {
    //定义Employee类，名字，工资，生日，生日为mydate类
    //mydate类包含年月日
    //创建三个对象，放入array list集合，泛型定义，sort排序，，传入comparator对象，按名字排，重复的按生日，遍历输出
    public static void main(String[] args) {
        ArrayList<Employee> arrayList = new ArrayList<>();
        arrayList.add(new Employee("jack",2000,new MyDate(2022,12,11)));
        arrayList.add(new Employee("jack",5000,new MyDate(2022,03,21)));
        arrayList.add(new Employee("tom",3000,new MyDate(2022,12,11)));
        System.out.println(arrayList);
        System.out.println("===========排序==============");
        arrayList.sort(new Comparator<Employee>() {
        @Override
        public int compare(Employee emp1, Employee emp2) {
            if (!(emp1 instanceof Employee && emp2 instanceof Employee)){
                System.out.println("类型不对");
                return 0;
            }
            int i = emp1.getName().compareTo(emp2.getName());
            if (i != 0) {
                return i;
            }
            return emp1.getBirthday().compareTo(emp2.getBirthday());
           }
        });
        System.out.println("==================排序后==========");
        System.out.println(arrayList);
    }
}
class Employee {
    private String name;
    private double sal;
    private MyDate birthday;

    public Employee(String name, double sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday +
                '}';
    }
}
class MyDate implements Comparable<MyDate>{
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "{" + year +
                "-" + month +
                "-" + day;
    }

    @Override
    public int compareTo(MyDate o) {
        //比较名字
        int yearMinus = year - o.getYear();
        if (yearMinus != 0){
            return yearMinus;
        }
        //如果重名，比较生日
        int monthMinus = month - o.getMonth();
        if (monthMinus != 0) {
            return monthMinus;
        }
        return day - o.getDay();
    }
}