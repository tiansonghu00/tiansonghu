package src.main.com.tian.exercise;

public class FinalExercise01 {
    //计算圆的面积，赋值的位置三个方式都写以下
    public static void main(String[] args) {
        Circle circle = new Circle(5.0);
        System.out.println("面积等于" + circle.area());
    }
}
class Circle {
    private double radius;
    private final double PI = 3.14;

    public Circle(double radius) {
        this.radius = radius;
        //PI = 3.14;
    }
    {
        //PI = 3.14;
    }
    public double area() {
        return PI * radius *radius;
    }
}
