package com.tian;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Collections_ {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("tom");
        list.add("smith");
        list.add("ling");
        list.add("king");
//添加
//①reverse(list):反转List中元素顺序
        Collections.reverse(list);
        System.out.println("list=" + list);
//②shuffle(List):对list集合元素进行随机排序
        for (int i = 0; i < 3; i++) {
            Collections.shuffle(list);
            System.out.println("list=" + list);
        }
//③sort(List,):根据元素的自然顺序对指定list集合元素按升序排序，按字母大小
        Collections.sort(list);
        System.out.println("list=" + list);
//④sort(List, Comparator):根据指定的Comparator产生的顺序对List集合元素进行排序
        Collections.sort(list, new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                return ((String)o1).length() - ((String)o2).length();
            }
        });
        System.out.println("list=" + list);
//⑤swap(List, int, int):将指定list集合中的之处元素和于处元素进行交换.
        Collections.swap(list,0,2);
        System.out.println("list=" + list);
// 查找、替换
//①Obgect max(Collection):根据元素的自然排序,返回给定集合中最大元素.
        System.out.println(Collections.max(list));
//②Object max(Collection, Comparator):根据Comparator指定的顺序,返回给定集合中的最大元素
        Object maxObject = Collections.max(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String)o1).length() - ((String)o2).length();
            }
        });
        System.out.println(maxObject);
//③Object min(Collection):根据元素的自然排序,返回给定集合中最小元素.
//④Object min(Collection, comparator):根据Comparator指定的顺序,返回给定集合中的最小元素
        //参考max
//⑤int frequency(Collection object):返回指定集合中指定元素出现次数
        System.out.println(Collections.frequency(list,"tom"));
//⑥void copy(List dest, listesrc):将src中内容复制到dest中
        ArrayList dest = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            dest.add("");
        }
        Collections.copy(dest,list);//注意数组大小，防止异常
        System.out.println(dest);
//⑦boolean replace All(List list, Object oldral, Object nemral):使用新值替换List对象的所有.旧值.
        Collections.replaceAll(list,"tom","wang");
        System.out.println(list);
    }
}
