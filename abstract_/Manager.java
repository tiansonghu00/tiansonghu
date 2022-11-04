package src.main.com.tian.abstract_;

public class Manager extends Employee{

    private double bonus;

    public Manager(String name, int id, double salary) {
        super(name, id, salary);
    }
    @Override
    public void work() {
        System.out.println("经理" + getName() + "工作中。。。");
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
