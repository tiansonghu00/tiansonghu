package src.main.com.tian.homework.homework9;

public class Homework09 {

    public static void main(String[] args) {
        Student student = new Student( "小明",'男',15,001);
        student.printInfo();
        System.out.println("===========================");
        Teacher teacher = new Teacher("关羽",'男',40,5);
        teacher.printInfo();

    //定义多态数组，保存学生，教师各2个，奈年龄从高到低排序
    Person person[] = new Person[4];
    person[0] = new Student("jack" ,'男',25,002);
    person[1] = new Student("tom" ,'男',15,003);
    person[2] = new Teacher("smith" ,'男',55,4);
    person[3] = new Teacher("scott" ,'男',45,5);

    Homework09 homework09 = new Homework09();
    homework09.bubbleSort(person);
    System.out.println("排序后");
        for (int i = 0; i < person.length; i++) {
            System.out.println(person[i]);
        }
        System.out.println("--------------");
        for (int i = 0; i < person.length; i++) {
            homework09.test(person[i]);
        }
    }
    //定义方法，形参为person类，调用学生或教师独有的方法,向下转型，类型判断
    public void test(Person p) {
        if (p instanceof Student) {//判断运行类型
            ((Student) p).study();
        } else if (p instanceof Teacher) {
            ((Teacher) p).teach();
        } else {
            System.out.println("null");
        }
    }

    //排序
    public void bubbleSort(Person person[]) {
        Person temp =null;
        for (int i = 0; i < person.length-1; i++) {
            for (int j = 0; j < person.length-1-i; j++) {
                if (person[j].getAge() < person[j+1].getAge()) {
                    temp = person[j];
                    person[j] = person[j+1];
                    person[j+1] = temp;
                }
            }
        }

    }
}
