package src.main.com.tian;

import java.util.Scanner;

public class TryCatchExercise {
    //如果用户输入的不是一个整数，就提示他反复输入，直到输入一个整数为止
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = 0;
        while (true) {
            System.out.println("请输入一个整数；");
            try {
                num = Integer.parseInt(scanner.next());//可能抛出异常
                break;
            } catch (NumberFormatException e) {
                System.out.println("输入的不是一个整数；");
            }
        }
        System.out.println("输入的是" + num);
    }


}
