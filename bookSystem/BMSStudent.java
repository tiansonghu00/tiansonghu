package com.tian.bookSystem;

import java.util.Scanner;
public class BMSStudent extends BMSManage {
    private Scanner sc = new Scanner(System.in);

    @Override
    void showMenu() {
        System.out.println("欢迎使用本系统");
        System.out.println("1.借阅图书");
        System.out.println("2.归还图书");
        System.out.println("0.退出");
    }

    @Override
    public void start() {
        while (true) {
            cls();
            showMenu();
            System.out.println("请输入操作");
            Integer i = Integer.valueOf(sc.nextLine());
            switch (i) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    borrowBook();
                    break;
                case 2:
                    returnBook();
                    break;
                default:
                    break;
            }
            System.out.println("按回车继续");
            sc.nextLine();
        }
    }
}
