package src.main.com.tian.exercise;

public class NotePad extends Computer{
    //编写notepad子类，继承computer类，添加特有属性演示color
    private String color;

    public NotePad(String cpu, int memory, int disk, String color) {
        super(cpu, memory, disk);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public void printInfo() {
        System.out.println("pc=");
        System.out.println(getDetails() + "color=" + color);
    }
}
