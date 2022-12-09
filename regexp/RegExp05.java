package com.tian.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp05 {
    //演示定位符的使用
    public static void main(String[] args) {
        //String content = "123-abc";
        String content = "tiansonghu saff afaftian";
        //以至少1个数字开头，后接任意个小写字母的字符串
        //String regStr = "^[0-9]+[a-z]*";
        //以至少1个数字开头，必须以至少一个小写字母结束
        //String regStr = "^[0-9]+\\-[a-z]+$";
        //表示匹配边界的tian，边界指被匹配的字符串最后
        String regStr = "tian\\b";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()) {
            System.out.println("找到" + matcher.group(0));
        }
    }
}
