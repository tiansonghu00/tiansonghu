package src.main.com.tian.smallchange.opp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChangeSysOOP {
    //完成零钱通各个功能，使用面向对象编程
    //先完成显示菜单，并可以选择
    boolean loop = true;
    Scanner scanner = new Scanner(System.in);
    String key = "";

    //可以先把收益入账和消费保存在数组；可以使用对象；可以使用String拼接
    String details = "--------零钱通明细--------";

    //完成收益ruz定义新的变量
    double money = 0;
    double balance = 0;
    Date date = null;//表示当前日期
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    //定义新变量,保存消费记录
    String note = "";
    public void mainMenu() {
        do {
            System.out.println("\n=======零钱通菜单OOP=======");
            System.out.println("\t\t1.零钱通明细");
            System.out.println("\t\t2.收益入账");
            System.out.println("\t\t3.消费情况");
            System.out.println("\t\t4.退出系统！");

            System.out.println("请选择(1-4):  ");
            key = scanner.next();
            //使用switch分支控制
            switch (key) {
                case "1" :
                    this.detail();
                    break;
                case "2" :
                    this.income();
                    break;
                case "3" :
                    this.pay();
                    break;
                case "4" :
                    this.exit();
                    break;
                default:
                    System.out.println("选择有误，重选");
            }
        } while (loop);
    }
    //完成零钱通明细
    public void detail() {
        System.out.println(details);
    }
    //完成收益入账
    public void income() {
        System.out.print("收益入账金额：");
        money = scanner.nextDouble();
        //钱的范围需要校验
        //判断不正常情况条件，给出提示,直接return
        if (money <= 0) {
            System.out.println("收益金额范围需要大于0");
            return;//退出，不再执行后面代码
        }
        balance += money;
        date = new Date();//获取当前日期
        //拼接收益信息
        details += "\n收益入账\t+" + money + "\t" + sdf.format(date) + "\t" + balance;
    }
    //完成消费
    public void pay() {
        System.out.println("消费金额：");
        money = scanner.nextDouble();
        //消费金额范围校验
        if (money <= 0 || money > balance) {
            System.out.println("消费金额应当在0-" + balance + "之间");
            return;
        }
        System.out.println("消费说明：");
        note = scanner.next();
        balance -= money;
        //拼接消费信息
        date = new Date();//获取当前日期
        details += "\n" +note + "\t\t-" + money + "\t" + sdf.format(date) + "\t" + balance;
    }
    //退出
    public void exit() {
        String choice = "";
        while (true) {//必须输入y/n，否则一直循环
            System.out.println("确认退出吗？y/n");
            choice = scanner.next();
            if ("y".equals(choice) || "n".equals(choice)) {
                break;
            }
        }
        //退出循环时，再判断输入的时y/n
        if (choice.equals("y")) {
            loop = false;//退出
            System.out.println("========退出了零钱通========");
        }
    }
}
