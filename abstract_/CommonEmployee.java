package src.main.com.tian.abstract_;

public class CommonEmployee extends Employee{
    public CommonEmployee(String name, int id, double salary) {
        super(name, id, salary);
    }

    @Override
    public void work() {
        System.out.println("工人" + getName() + "正在工作。。。");
    }
}
