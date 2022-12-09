package com.tian.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherMethod {
    //Matcher类的常用方法
    public static void main(String[] args) {
        String content = "hello world jack tom ok hello";
        String regStr = "hello";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()) {
            System.out.println("=========================");
            System.out.println(matcher.start());//开头的索引
            System.out.println(matcher.end());//结尾的索引
            System.out.println("找到：" + content.substring(matcher.start(),matcher.end()));
        }
        //整体匹配方法，常用于校验某个字符串是否满足某个规则
        System.out.println(matcher.matches());
        //将content中的hello替换成你好
        regStr = "hello";
        pattern = Pattern.compile(regStr);
        matcher = pattern.matcher(content);
        //注意：返回的字符串才是替换后的，content不变化
        String newContent = matcher.replaceAll("你好");
        System.out.println(content);
        System.out.println(newContent);
    }
}
