package src.main.com.tian.homework.homework9;

public class Person {
    //父类，共同属性和方法放这里，定义方法，形参为person类，调用学生或教师独有的方法
    private String name;
    private char sex;
    private int age;

    public Person(String name, char sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public String play() {
        return name + "爱玩";
    }
    public String baseInfo() {
        return "姓名：" + name + "\n年龄：" + age + "\n性别：" + sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                '}';
    }
}
