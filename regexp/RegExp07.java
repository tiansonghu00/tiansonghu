package com.tian.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp07 {
    //演示非捕获分组,不能使用matcher.group(1)
    public static void main(String[] args) {
        String content = "hello托尼先生 托尼老师 托尼同学hello";
        //String regStr = "托尼先生|托尼老师|托尼同学";
        String regStr = "托尼(?:先生|老师|同学)";
        //String regStr = "托尼(?=先生|老师|同学)";//找到三个托尼
        //String regStr = "托尼(?!先生|老师)";//只返回一个托尼
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()) {
            System.out.println("找到=" + matcher.group(0));
        }
    }
}
