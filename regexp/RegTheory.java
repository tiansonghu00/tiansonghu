package com.tian.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegTheory {
    public static void main(String[] args) {
        //分析java的正则表达式的底层实现
        String content = "1998年12月8日，第二代Java平台的企业版J2EE发布。1999年6月，Sun公司发布了第二代Java平台（简称为Java2）的3个版本：" +
                "J2ME（Java2 Micro Edition，Java2平台的微型版），应用于移动、无线及有限资源的环境；J2SE（Java 2 Standard Edition，Java 2平台的标准版），" +
                "应用于桌面环境；J2EE（Java 2Enterprise Edition，Java 2平台的企业版），应用于基于Java的应用服务器。Java 2平台的发布，" +
                "是Java发展过程中最重要的一个里程碑，标志着Java的应用开始普及。 作者：Java代码敲不完 https://www.bilibili.com/read/cv12001722 出处：bilibili";
        // \\d表示一个任意数字，
        String regStr = "\\d\\d\\d\\d";
        //创建模式对象
        Pattern pattern = Pattern.compile(regStr);
        //创建一个匹配器,按照正则表达式的规则去匹配content字符串
        Matcher matcher = pattern.matcher(content);
        //开始匹配
        /**
         * matcher.find()完成的任务
         * 1.根据指定的规则，定位满足规则的子字符串（比如1998）
         * 2.找到后，将子字符串的开始索引记录到matcher对象的属性int[] groups;
         * groups[0] = 0,把该子字符串的结束的索引+1的值记录到groups[1] = 4
         * 记录1组()匹配到的字符串groups[2] = 0 groups[3] = 2
         * 记录2组()匹配到的字符串groups[4] = 2 groups[5] = 4
         * 如果有更多的分组
         * 3.同时记录oldLast的值为子字符串结束的索引+1的值，即4，即下次执行find方法时，从4开始匹配
         * matcher.group(0)分析
         * public String group(int group) {
         *         if (first < 0)
         *             throw new IllegalStateException("No match found");
         *         if (group < 0 || group > groupCount())
         *             throw new IndexOutOfBoundsException("No group " + group);
         *         if ((groups[group*2] == -1) || (groups[group*2+1] == -1))
         *             return null;
         *         return getSubSequence(groups[group * 2], groups[group * 2 + 1]).toString();
         *     }
         * 1.根据groups[0]和groups[1]的记录的位置，从content开始截取子字符串[0,4)返回
         * 考虑分组，（\d\d）（\d\d）正则表达式有()，第一个()表示第一组，第二个就表示第二组
         *
         */
        while (matcher.find()) {
            System.out.println("找到：" + matcher.group(0));
        }
    }
}
