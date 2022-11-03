package src.main.com.tian.homework;

public class Associate extends Teacher{
    public Associate(String name, int age, String post, double salary, double grade) {
        super(name, age, post, salary, grade);
    }
    public void introduce() {
        System.out.println("这是副教授的信息");
        super.introduce();
    }
}
