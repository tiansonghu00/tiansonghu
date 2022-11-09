package src.main.com.tian.String_;

public class String_02 {
    //编写程序，输入形式为Han Shun Ping的人名，以Ping，Han .S的形式打印出来，.S是中间单词首字母
    public static void main(String[] args) {
        String name = "Will Be Success";
        printName(name);
    }
    public static void printName(String str) {
        if (str == null) {
            System.out.println("str不能为空");
            return;
        }
        String names[] = str.split(" ");
        if (names.length != 3) {
            System.out.println("输入格式不对");
            return;
        }
        String format = String.format("%s,%s .%c", names[2],names[0],names[1].toUpperCase().charAt(0));
        System.out.println(format);
    }
}
