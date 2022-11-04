package src.main.com.tian.abstract_;

public class AbstractExercise {
    //对于manager类来说，即使员工，还有奖金属性
    public static void main(String[] args) {
        Manager manager = new Manager("jack", 001, 10000);
        manager.setBonus(2000);
        manager.work();

        CommonEmployee commonEmployee = new CommonEmployee("tom", 002, 5000);
        commonEmployee.work();
    }
}
