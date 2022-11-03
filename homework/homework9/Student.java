package src.main.com.tian.homework.homework9;

public class Student extends Person{
    //名称，性别sex，年龄，学号stu_id，合理封装，构造器
    //学生要有学习方法，有玩的方法，玩足球，返回字符串
    private int stu_id;

    public Student(String name, char sex, int age, int stu_id) {
        super(name, sex, age);
        this.stu_id = stu_id;
    }
    public int getStu_id() {
        return stu_id;
    }
    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }
    public void study() {
        System.out.println(getName() + "好好学习，天天向上");
    }

    @Override
    public String play() {
        return super.play() + "足球";
    }
    public void printInfo() {
        System.out.println("学生信息：");
        System.out.println(super.baseInfo());
        System.out.println("学号：" + stu_id);
        study();
        System.out.println(play());
    }

    @Override
    public String toString() {
        return "Student{" +
                "stu_id=" + stu_id +
                '}' + super.toString();
    }
}
