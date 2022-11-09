package src.main.com.tian.String_;

public class UserRegister {
    //输入用户名密码，邮箱，如果录入正确，提示注册成功，否则异常
    //用户名长度2-4，密码6位纯数字，邮箱包含@，.，并且@在前
    public static void main(String[] args) {
        String name = "jack";
        String pwd = "123456";
        String email = "jack@qq.com";
        try {
            userRegister(name,pwd,email);
            System.out.println("注册成功!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void userRegister (String name, String pwd, String email) {
        if (!(name != null && pwd != null && email != null)) {
            throw new RuntimeException("参数不能为空");
        }
        int userLength = name.length();
        if (!(userLength >= 2 && userLength <= 4)) {
            throw new RuntimeException("用户名字长度2-4");
        }
        if (!(pwd.length() == 6 && isDigital(pwd))) {
            throw new RuntimeException("密码要为6位纯数字");
        }
        int i = email.indexOf('@');
        int j = email.indexOf('.');
        if (!(i > 0 && j > i )) {
            throw new RuntimeException("邮箱应当包含@和.，并且@在前");
        }
    }
    //判断密码是否纯数字
    public static  boolean isDigital(String str) {
        char chars[] = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] < '0' || chars[i] > '9') {
                return false;
            }
        }
        return true;
    }
}