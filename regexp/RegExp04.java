package com.tian.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp04 {
    //正则限定符
    public static void main(String[] args) {
        String content = "1a1111111111111aaaaaaaaaaaahello";
        //a{3},1{4},\\d{2}
        //String regStr - "a{3}";//表示匹配aaa
        //String regStr - "1{4}";//表示匹配1111
        //String regStr - "\\d{2}";//表示匹配两位的任意数字字符
        //a{3,4},1{4,5},\\d{2,5}
        //java匹配默认贪婪匹配，即尽可能匹配多的
        //String regStr = "a{3,4}";//表示匹配aaa或aaaa
        //String regStr = "1{4,5}";//表示匹配1111或11111
        //String regStr = "\\d{2,5}";//匹配2位数或者3，4,5

        //String regStr = "1+";//匹配一个1或者多个1
        //String regStr = "\\d+";//匹配一个或多个数字
        //String regStr = "1*";//匹配0个1或者多个1
        String regStr = "a1?";//匹配a或者a1
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()) {
            System.out.println("找到" + matcher.group(0));
        }
    }
}
