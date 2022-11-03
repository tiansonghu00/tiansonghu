package src.main.com.tian.exercise;

public class PC extends Computer{
    //编写pc子类，继承computer类，添加特有属性品牌brand
     private String brand;

    public PC(String cpu, int memory, int disk, String brand) {
        super(cpu, memory, disk);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void printInfo() {
        System.out.println("pc=");
        System.out.println(getDetails() + "brand=" + brand);
    }
}
