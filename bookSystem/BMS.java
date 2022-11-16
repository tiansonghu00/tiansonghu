package com.tian.bookSystem;

import java.util.HashMap;
import java.util.Scanner;

public class BMS {
    //泛型约束，定义输入必须为String类参数
    private HashMap<String,String> manager=new HashMap<>();
    private HashMap<String,String> student=new HashMap<>();
    private Scanner sc = new Scanner(System.in);

    public BMS() {//分开定义管理员和学生，后续可以存放在properties中
        manager.put("admin","123456");
        student.put("student","123456");
    }
    public void start() {//进行登录用户判断
        BMSManage bms;
        while (true){
            System.out.println("请输入账号");
            String username = sc.nextLine();
            System.out.println("请输入密码");
            String password = sc.nextLine();
            //进行比较，输入和预存的信息是否一致
            if(manager.containsKey(username)&&manager.get(username).equals(password)){
                bms=new BMSManage();
                break;
            }
            if(student.containsKey(username)&&student.get(username).equals(password)){
                bms=new BMSStudent();
                break;
            }
            System.out.println("登录失败");
            System.out.println("按回车继续");
            sc.nextLine();
        }
        bms.start();
    }
}
