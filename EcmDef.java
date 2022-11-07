package src.main.com.tian;

import java.util.Scanner;

public class EcmDef {
    //接收命令行两个整数，计算相除，用方法cal，格式不对，缺少参数，除数为0，出异常
    public static void main(String[] args) {
        try {
            if (args.length != 2) {
                throw new ArrayIndexOutOfBoundsException("参数个数不对");
            }
            int n1 = Integer.parseInt(args[0]);
            int n2 = Integer.parseInt(args[1]);
            double res = cal(n1,n2);
            System.out.println("结果为=" + res);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("格式不对，需要整数");
        } catch (ArithmeticException e) {
            System.out.println("出现除数为0情况");
        }
    }
    public static  double cal(int n1,int n2) {
        return n1 / n2;
    }
}