package src.main.com.tian.homework;

public class lecturer extends Teacher{
    public lecturer(String name, int age, String post, double salary, double grade) {
        super(name, age, post, salary, grade);
    }
    public void introduce() {
        System.out.println("这是讲师的信息");
        super.introduce();
    }
}
