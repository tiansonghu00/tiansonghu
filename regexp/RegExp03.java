package com.tian.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp03 {
    //演示字符匹配符使用
    public static void main(String[] args) {
        String content = "a11c8ABC";
        //String regStr = "[a-z]";//匹配a-z之间任意一个字符
        //String regStr = "[A-Z]";//匹配A-Z之间任意一个字符
        //String regStr = "[^A-Z]";//匹配不是A-Z之间任意一个字符
        //String regStr = "(?i)abc";//匹配abc字符串，不区分大小写
        //String regStr = "[abcd]";//匹配abcd中任意一个字符
        String regStr = "abc";
        //当创建pattern对象时，指定Pattern.CASE_INSENSITIVE，表示匹配是不区分大小写的
        Pattern pattern = Pattern.compile(regStr,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()) {
            System.out.println("找到" + matcher.group(0));
        }
    }
}
