package src.main.com.tian;

import java.util.HashMap;
import java.util.HashSet;

public class HashSetSource {
    public static void main(String[] args) {

        HashSet hashSet = new HashSet();
        hashSet.add("jack");
        hashSet.add("php");
        hashSet.add("java");
        System.out.println("set= " + hashSet);
    }
}
/*
    final V putVal(int hash, K key, V value, boolean onlyIfAbsent,boolean evict) {
        //定义了辅助变量
        HashMap.Node<K,V>[] tab; HashMap.Node<K,V> p; int n, i;
        //table就是HashMap的一个数组，类型时Node[]
        if ((tab = table) == null || (n = tab.length) == 0)
        //resize()方法中，table为0时，
        //  newCap = DEFAULT_INITIAL_CAPACITY;16
        //  newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);(int)(0.75*16)=12计算临界值,起到缓冲作用
        //  static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16
        //将开辟好的newCap赋给table
            n = (tab = resize()).length;
        //(1)根据key得到hash,去计算应该存放到table表的哪个索引位置，并且把这个位置的对象赋给辅助变量p
        //(2)判断p是否为空，为空，表示还没有存放元素，就创建一个Node,放在该位置tab[i]
        //第二次添加：会直接执行这段语句
        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);
        else {
        //第二次添加：在需要局部变量（辅助变量）时候，再创建
            HashMap.Node<K,V> e; K k;
            //第二次添加：会从这里开始执行，上面的if语句不执行，因为不会再为null
            if (p.hash == hash &&   //如果当前索引位置对应的链表的第一个元素和准备添加的key的hash值一样
            //第二次添加：并且满足  准备加入的key和p指向的Node结点的key是同一个对象，或者p指向的Node结点的key的equals()和
            准备加入的key比较后相同，就不能加入。equals()方法时可以由程序员重写来确定比较标准的
                    ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
            //第二次添加：再判断p是不是一颗红黑树，如果是一颗红黑树，就调用putTreeVal，来进行添加
            else if (p instanceof HashMap.TreeNode)
                e = ((HashMap.TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            else {//如果当前table对应索引位置，已经是一个链表，就使用for循环比较
 // 第二次添加：（1）依次和该链表每一个元素比较后，都不相同，说明添加的元素没有重复，则加入到该链表最后
            //（2）依次比较过程中，如果有相同情况，就直接break
                for (int binCount = 0; ; ++binCount) {//死循环
                    if ((e = p.next) == null) {
                        p.next = newNode(hash, key, value, null);
            //（3）注意：在把元素添加到链表后，立即判断，该链表是否已经达到8个节点，达到就调用treeifyBin()方法对当前链表进行树化
            //转成红黑树时，要进行判断，条件如下：if (tab == null || (n = tab.length) < MIN_TREEIFY_CAPACITY)64   resize();
            //如果上面条件成立，先对table扩容，只有上面条件不成立时，才进行树化
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);
                        break;
                    }
                    if (e.hash == hash &&
                            ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++modCount;
        //判断是否需要扩容
        if (++size > threshold)//size就是每加入一个结点Node（key,value,hash,next）,size就会++
            resize();
        //void afterNodeInsertion(boolean evict) { }
        afterNodeInsertion(evict);
        return null;
    }
*/