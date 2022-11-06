package com.tian.homework.homework10;

public class Homework10_5 {
    //交通工具接口Vehicles，有work接口，有Horse类，Boat类分别实现Vehicles
    //创建交通工具工厂类，有两个方法分别获得交通工具Horse，boat
    //有person类，有name，vehicle属性，在构造器中赋值
    //实例化person对象唐僧，要求一般情况用horse，大河用boat
    public static void main(String[] args) {
        Person person = new Person("唐僧",new Horse());
        person.passRoad();
        person.passRiver();
        person.passRoad();
        person.passRiver();
    }
}
interface Vehicles {
    public void work();
}
class Horse implements Vehicles{
    public void work(){
        System.out.println("一般情况骑马");
    }
}
class Boat implements Vehicles{
    @Override
    public void work() {
        System.out.println("过大河用船");
    }
}
class VehiclesFactory {
    private static Horse horse = new Horse();

    private VehiclesFactory() {
    }
    public static Horse getHorse() {
        return horse;
    }
    public static Boat getBoat() {
        return new Boat();
    }
}
class Person {
    private String name;
    private Vehicles vehicles;

    public Person(String name, Vehicles vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }
    public void passRiver() {
        if (!(vehicles instanceof Boat)) {
            vehicles = VehiclesFactory.getBoat();
        }
        vehicles.work();
    }
    public void passRoad() {
        if (!(vehicles instanceof Horse)) {
            vehicles = VehiclesFactory.getHorse();
        }
        vehicles.work();
    }
}
