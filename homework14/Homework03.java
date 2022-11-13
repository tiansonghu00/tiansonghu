package com.tian.homework14;

import java.util.*;

public class Homework03 {
    /*
    按要求完成下列任务
       使用HashMap类实例化一个Map类型的对象m,键(String)和值(int)分别用于存储员工的姓名和工资，
        存入数据如下：jack—650元; tom—1200元; smith——2900元;
     */
    public static void main(String[] args) {
        Map m = new HashMap();
        m.put("jack",650);
        m.put("tom",1200);
        m.put("smith",2900);
        System.out.println(m);
        //将jack的工资更改为2600元
        m.put("jack",2600);
        //为所有员工工资加薪100元；
        Set keySet = m.keySet();
        for (Object key : keySet) {
            m.put(key, (Integer)m.get(key)+100);
        }
        System.out.println(m);
        //遍历EntrySet，遍历集合中所有的员工
        Set entrySet = m.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry =  (Map.Entry)iterator.next();
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
        System.out.println("==================================");
        //遍历集合中所有的工资
        Collection values = m.values();
        for (Object o :values) {
            System.out.println("工资=" + o);
        }

    }
}
