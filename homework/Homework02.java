package src.main.com.tian.homework;

public class Homework02 {
    //老师类，要求有属性姓名，年龄，职称，基本工资，
    //业务方法introdduce，实现输出一个教师的信息
    //三个子类，教授，副教授，讲师，工资级别1.3，1.2，1.1，都重写introduce
    //定义并初始化一个老师对象，调用业务方达，实现信息后台打印
    public static void main(String[] args) {
        Professor professor = new Professor("jack",40,"高级",6000,1.3);
        professor.introduce();
    }

}

