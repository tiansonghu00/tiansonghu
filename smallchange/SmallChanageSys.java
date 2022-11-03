package src.main.com.tian.smallchange;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChanageSys {
    //1.先完成显示菜单，并能给出对应提示信息
    //2.完成零钱通明细
    //3.完成收益入账
    //4.完成消费情况
    //5.退出,提示是否退出，必须输入正确y/n，否则循环
    //6.金额校验
    public static void main(String[] args) {
        //定义相关变量
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
        do {
            System.out.println("\n========零钱通菜单========");
            System.out.println("\t\t1.零钱通明细");
            System.out.println("\t\t2.收益入账");
            System.out.println("\t\t3.消费情况");
            System.out.println("\t\t4.退出系统！");

            System.out.println("请选择(1-4):  ");
            key = scanner.next();
            //使用switch分支控制
            switch (key) {
                case "1" :
                    System.out.println(details);
                    break;
                case "2" :
                    System.out.print("收益入账金额：");
                    money = scanner.nextDouble();
                    //钱的范围需要校验
                    //判断不正常情况条件，给出提示,直接break
                    if (money <= 0) {
                        System.out.println("收益金额范围需要大于0");
                        break;
                    }
                    balance += money;
                    date = new Date();//获取当前日期
                    //拼接收益信息
                    details += "\n收益入账\t+" + money + "\t" + sdf.format(date) + "\t" + balance;
                    break;
                case "3" :
                    System.out.println("消费金额：");
                    money = scanner.nextDouble();
                    //消费金额范围校验
                    if (money <= 0 || money > balance) {
                        System.out.println("消费金额应当在0-" + balance + "之间");
                        break;
                    }
                    System.out.println("消费说明：");
                    note = scanner.next();
                    balance -= money;
                    //拼接消费信息
                    date = new Date();//获取当前日期
                    details += "\n" +note + "\t\t-" + money + "\t" + sdf.format(date) + "\t" + balance;
                    break;
                case "4" :
                    //定义变量choice，接收输入，使用while + break处理接收
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
                    }
                    break;
                default:
                    System.out.println("选择有误，重选");
            }
        } while (loop);
        System.out.println("========退出了零钱通========");
    }
}
