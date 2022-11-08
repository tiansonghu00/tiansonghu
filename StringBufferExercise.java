package src.main.com.tian;

import java.util.Scanner;

public class StringBufferExercise {
    //输入商品名称和价格，打印，价格的小数点前面，每三位用逗号隔开
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String price = scanner.next();
//      String price = "4343159456.66";
        StringBuffer sb = new StringBuffer(price);
//        int i = sb.lastIndexOf(".");
//        sb = sb.insert(i - 3,",");
        for (int i = sb.lastIndexOf(".")- 3 ;i > 0; i -=3) {
            sb = sb.insert(i,",");
        }
        System.out.println(sb);
    }
}
