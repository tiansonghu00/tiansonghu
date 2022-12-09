package com.tian.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp09 {
    //对字符串进行如下验证
    public static void main(String[] args) {
        //汉字
        //String content = "你好";
        //String regStr = "^[\u0391-\uffe5]$";//可查，汉字的范围
        //邮政编码，1-9开头的一个六位数
        //String regStr = "^[1-9]\\d{5}$";
        //QQ号码，1-9开头的5-10位数
        //String regStr = "^[1-9]\\d{4,9}$";
        //手机号码，必须以13,14,15,18开头的11位数
        //String regStr = "^1[3|4|5|8]\\d{9}$";
        //url
        String content = "https://www.bilibili.com/video/BV1fh411y7R8/?p=893&spm_id_from=333.880.my_history.page.click&vd_source=7f8b457d3bb9eacf4c55e1c7e1a4780d";
        /**
         * 先确定URL，的开始部分位https://or http://
         * \\w ：匹配任意英文字符，数字和下划线 ([\w-]+\.)+对应www.bilibili.
         * [\w-]+$ 对应com (\/[\w-?=&/%.#]*)?$ 对应com后面那一长串，w后面是地址中可能出现的符号
         */
        String regStr = "^((http|https)://)([\\w-]+\\.)+[\\w-]+(\\/[\\w-?=&/%.#]*)?$";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);

        if (matcher.find()) {
            System.out.println("满足格式");
        } else {
            System.out.println("不满足格式");
        }

    }
}
