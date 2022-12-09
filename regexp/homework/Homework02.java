package com.tian.regexp.homework;

public class Homework02 {
    //验证是不是整数或者小数
    public static void main(String[] args) {
        String content = "+0.05";
        String regStr = "^[-+]?([1-9]\\d*|0)(\\.\\d+)?$";
        if (content.matches(regStr)) {
            System.out.println("验证成功");
        } else {
            System.out.println("验证失败");
        }
    }
}
