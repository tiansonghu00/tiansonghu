package com.tian.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp06 {
    //分组
    public static void main(String[] args) {
        String content = "tiansonghu saff afaftian";
        String regStr = "(?<g1>\\d\\d)(?<g2>\\d\\d)";//匹配4个数字的字符串
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()) {
            System.out.println("找到" + matcher.group(0));
            System.out.println("第1个分组内容" + matcher.group(1));
            System.out.println("第1个分组内容方法2" + matcher.group("g1"));
            System.out.println("第2个分组内容" + matcher.group(2));
            System.out.println("第2个分组内容方法2" + matcher.group("g2"));
        }
    }
}
