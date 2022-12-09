package com.tian.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp10 {
    //反向引用
    public static void main(String[] args) {
        //String content = "hello66666 jack14 tom5225 jack22 yyy xxx";
        String content = "12321-333999111";
        //匹配两个连续的相同数字
        //String regStr = "(\\d)\\1";
        //匹配五个连续的相同数字
        //String regStr = "(\\d)\\1{4}";
        //匹配个位和千位相同，十位和百位相同的数
        //String regStr = "(\\d)(\\d)\\2\\1";
        //检索商品编号，如12321-333999111
        //前面是一个五位数，然后一个-，然后是九位数，连续的每三位都相同
        String regStr = "\\d{5}-(\\d)\\1{2}(\\d)\\2{2}(\\d)\\3{2}";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()) {
            System.out.println("找到=" + matcher.group(0));
        }
    }
}
