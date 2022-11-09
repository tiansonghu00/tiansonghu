package src.main.com.tian.String_;

public class String_01 {
    //将字符串中指定部分进行反转，abcdef,变为aedcbf
    public static void main(String[] args) {
        String str = "abcdef";
        System.out.println(str);
        try {
            str = reverse(str,1,4);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("交换后");
        System.out.println(str);
    }
    public static String reverse(String str,int start,int end) {
        //写出正确的情况，再取反
        if (!(str != null && start >= 0 && end > start && end < str.length() )) {
            throw new RuntimeException("参数错误");
        }
        //把string转换成char[]，因为char[]的元素是可以交换的
        char chars[] = str.toCharArray();
        char temp = ' ';
        for (int i = start,j = end; i <j; i++,j--) {
            temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return new String(chars);
    }
}

