package src.main.com.tian.homework;

public class Homework01 {
    //定义一个person类，名字，年龄，工作，初始化，三个person对象
    public static void main(String[] args) {
        Person person[] = new Person[3];
        person[0] = new Person("jack",55,"工人");
        person[1] = new Person("tom",35,"教师");
        person[2] = new Person("mark",45,"医生");
        //输出当前对象数组
        for (int i = 0; i < person.length; i++) {
            System.out.println(person[i]);
        }
        //排序
        Person temp = null;
        for (int i = 0; i < person.length - 1; i++) {
            for (int j = 0; j < person.length - 1 -i; j++) {
                //按年龄排序，从小到大
                if (person[i].getAge() > person[i+1].getAge()) {
                    temp = person[i];
                    person[i] = person[i+1];
                    person[i+1] = temp;
                }
            }
        }

        System.out.println("======排序后========");
        for (int i = 0; i < person.length; i++) {
            System.out.println(person[i]);
        }
    }
}
class Person {
    private String name;
    private int age;
    private String job;

    public Person(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                '}';
    }
}