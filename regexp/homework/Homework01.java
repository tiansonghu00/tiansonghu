package com.tian.regexp.homework;

public class Homework01 {
    //规定电子邮件规则，只能有一个@，@前是用户名，可以是任意英文字符，数字，下划线
    //@后是域名，纯英文字母
    public static void main(String[] args) {
        String content = "tian@qq.com";
        String regStr = "^[\\w-]+@([a-zA-Z]+\\.)+[a-zA-Z]+$";
        if (content.matches(regStr)) {
            System.out.println("验证成功");
        } else {
            System.out.println("验证失败");
        }
    }
}
