import java.util.Scanner;

public class MulFor02 {
    public static void main(String[] args) {
        //打印久久乘法表
        for (int i = 1; i <= 9; i++){
            for (int j = 1; j <= i; j++){
                System.out.print(i + "*" + j +"=" + (i * j)+"\t");
            }
            System.out.println();
        }
    }
}
