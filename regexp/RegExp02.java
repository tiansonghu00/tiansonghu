package com.tian.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp02 {
    //演示转义字符到的使用
    public static void main(String[] args) {
        String content = "abc$(abc(123(";
        //匹配（
        //转义号\\,需要用到转义符号的字符有.*+()$\/?[]^{}
        String regStr = "\\(";//两个\\代表其他语言中的一个\
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println("找到" + matcher.group(0));
        }
    }
}
