package src.main.com.tian;

import java.util.HashSet;
import java.util.Objects;

public class HashSetExercise {
    //定义一个Employee类，包含名字和年龄，创建三个Employee放入HashSet
    //当名字和年龄的值相同时，认为是同一人，不能添加
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        boolean jack = hashSet.add(new Employee("jack", 16));
        boolean tom = hashSet.add(new Employee("tom", 18));
        boolean ak = hashSet.add(new Employee("jack", 16));
        System.out.println(hashSet);
    }
}
class Employee{
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    //如果名字和年龄相同，则返回相同的hash值

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}