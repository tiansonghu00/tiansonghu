package com.tian;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayExercise {
    //定义book类，包含名字，价格，按价格从大到小排序，使用两种方式排序
    public static void main(String[] args) {
        Book books[] = new Book[4];
        books[0] = new Book("红楼梦合集",100);
        books[1] = new Book("西游记续传全集",90);
        books[2] = new Book("三国演义",110);
        books[3] = new Book("水浒传",95);
        //价格从大到小
        Arrays.sort(books, new Comparator() {
            //这里是对Book数组排序，因此，o1,o2是Book对象
            @Override
            public int compare(Object o1, Object o2) {
                Book book1 = (Book) o1;
                Book book2 = (Book) o2;
                double priceVal = book2.getPrice() - book1.getPrice();
                if (priceVal > 0) {
                    return 1;//-1
                } else if (priceVal < 0) {
                    return -1;//1变更完就是从小到大
                } else {
                    return 0;
                }
            }
        });
        //按书名长度排序,从大到小
        System.out.println(Arrays.toString(books));
        Arrays.sort(books, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Book book1 = (Book) o1;
                Book book2 = (Book) o2;
                return book2.getName().length() - book1.getName().length();
//              从小到大
//              return book2.getName().length() - book1.getName().length();
            }
        });
        System.out.println("===================================");
        System.out.println(Arrays.toString(books));
    }
}
class Book {
    private String name;
    private double price;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
