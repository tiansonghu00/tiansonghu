package src.main.com.tian.homework.homework9;

public class Teacher extends Person{
    //名称，性别，年龄，工龄work_age
    //老师要有教学方法，玩象棋
    private int work_age;

    public Teacher(String name, char sex, int age, int work_age) {
        super(name, sex, age);
        this.work_age = work_age;
    }

    public int getWork_age() {
        return work_age;
    }

    public void setWork_age(int work_age) {
        this.work_age = work_age;
    }
    public void teach() {
        System.out.println(getName() + "为人师表，教书育人");
    }

    @Override
    public String play() {
        return super.play() + "象棋";
    }

    public void printInfo() {
        System.out.println("老师信息：");
        System.out.println(super.baseInfo());
        System.out.println("工龄：" + work_age);
        teach();
        System.out.println(play());
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "work_age=" + work_age +
                '}' + super.toString();
    }
}
