package src.main.com.tian;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetSource {
    public static void main(String[] args) {
        //分析底层机制
        Set set = new LinkedHashSet();
        set.add(new String("AA"));
        set.add(456);
        set.add(456);
        set.add(new Customer("刘",1001));
        set.add(123);
        set.add("HSP");
        System.out.println(set);

        //1.加入顺序和取出元素顺序一致
        //2.底层维护的是一个LinkedHashMap(是HashMap的子类)
        //3.底层结构（数组+双向链表）
        //4.添加第一次时，直接将table扩容到16，存放的数组是HashMap$Node[]   结点类型时LinkedHashMap$Entry
        // 继承关系是在内部类完成
//        static class Entry<K,V> extends HashMap.Node<K,V>
//
    }
}
class Customer{
    private String name;
    private int no;

    public Customer(String name, int no) {
        this.name = name;
        this.no = no;
    }
}
