package com.tian.bookSystem;

import java.text.SimpleDateFormat;
import java.util.*;

public class BMSManage {//管理员页面
    private ArrayList<Book> bookList = new ArrayList<>();
    private HashMap<String, ArrayList<Book>> bookMap = new HashMap<>();

    private Scanner sc = new Scanner(System.in);

    void cls(){
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    void showMenu() {
        System.out.println("欢迎使用本图书管理系统");
        System.out.println("1.查看图书分类");
        System.out.println("2.查看分类下的图书");
        System.out.println("3.按书名查找图书");
        System.out.println("4.查看借出信息");
        System.out.println("5.新增图书");
        System.out.println("6.修改图书");
        System.out.println("7.删除图书");
        System.out.println("8.查看全部图书");
        System.out.println("9.借阅图书");
        System.out.println("10.归还图书");
        System.out.println("0.退出");
    }

    public static void main(String[] args) {
        BMSManage bms = new BMSManage();
        bms.start();
    }

    public void start() {//启动系统
        while (true) {
            cls();
            showMenu();
            System.out.println("请输入操作");
            Integer i = Integer.valueOf(sc.nextLine());
            switch (i) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    showKindList();
                    break;
                case 2:
                    System.out.println("请输入类别");
                    String kind = sc.nextLine();
                    showBookListByKind(kind);
                    break;
                case 3:
                    System.out.println("请输入书的书名");
                    String name = sc.nextLine();
                    showBookListByName(name);
                    break;
                case 4:
                    showBorrowBook();
                    break;
                case 5:
                    addBook();
                    break;
                case 6:
                    updateBook();
                    break;
                case 7:
                    deleteBook();
                    break;
                case 8:
                    showAllBook();
                    break;
                case 9:
                    borrowBook();
                    break;
                case 10:
                    returnBook();
                    break;
                default:
                    break;
            }
            System.out.println("按回车继续");
            sc.nextLine();
        }
    }

    public void showKindList() {//查看图书分类
        Set<String> set = bookMap.keySet();
        for (String s : set) {
            System.out.println(s);
        }
    }

    public void showBookListByKind(String kind) {//按分类查看图书
        // 判断是否存在该类型，存在则遍历
        if (bookMap.containsKey(kind)) {
            ArrayList<Book> list = bookMap.get(kind);
            for (Book book : list) {
                System.out.println(book);
            }
        } else {
            System.out.println("没有该图书");
        }
    }

    // 根据name遍历list，符合则打印
    public void showBookListByName(String name) {//按书名查找书
        for (Book book : bookList) {
            if (book.getName().equals(name)) {
                System.out.println(book);
            }
        }
    }

    public void showBorrowBook(){
        System.out.println("借阅的图书信息");
        // 判断是否借阅
        for (Book book:bookList){
            if(!book.isStatus()){
                System.out.println(book);
            }
        }
        System.out.println("超时未归还的图书信息");
        for(Book book:bookList){
            if(!book.isStatus()){
                // 比较预计归还时间是否在今天之前
                SimpleDateFormat myFormat=new SimpleDateFormat("yyyy-MM-dd");
                String myDate = myFormat.format(new Date());
                if(myDate.compareTo(book.getReturnTime()) > 0){
                    System.out.println(book);
                }
            }
        }
    }

    public void addBook() {
        System.out.println("请输入书本的名字");
        String name = sc.nextLine();
        System.out.println("请输入书本的类别");
        String kind = sc.nextLine();
        System.out.println("请输入书本的出版时间（按照 yyyy-mm-dd）的形式输入");
        String publishedTime = sc.nextLine();
        System.out.println("请输入书本的作者");
        String author = sc.nextLine();
        Book book = new Book(null,name, kind, publishedTime, author, true);
        boolean f = true;
        for (Book item : bookList) {
            //根据书名，作者，出版时间确定唯一
            if (item.getName().equals(name)
                    && item.getAuthor().equals(author)
                    && item.getPublishedTime().equals(publishedTime)) {
                System.out.println("已经存在该图书");
                f = false;
                break;
            }
        }
        if (f) {
            // 默认设置 id 为数组下标
            book.setId(bookList.size());
            // 在list中添加
            bookList.add(book);
            // 判断map中key为kind的是否已经初始化，没有初始化则初始化
            if (!bookMap.containsKey(book.getKind())) {
                bookMap.put(book.getKind(), new ArrayList<>());
            }
            // 添加book信息
            bookMap.get(book.getKind()).add(book);
            System.out.println("添加成功");
            System.out.println(book);
        }
    }

    public void updateBook() {
        System.out.println("请输入书本的编号");
        Integer id=Integer.valueOf(sc.nextLine());
        int temp = bookList.size();
        // 查找是否存在该书本
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getId().equals(id)) {
                temp = i;
                break;
            }
        }
        if (temp == bookList.size()) {
            System.out.println("该书不存在");
        } else {
            // 修改图书
            System.out.println("请输入书本的名字");
            String  name = sc.nextLine();
            System.out.println("请输入书本的类别");
            String kind = sc.nextLine();
            System.out.println("请输入书本的出版时间（按照 yyyy-mm-dd）的形式输入");
            String publishedTime = sc.nextLine();
            System.out.println("请输入书本的作者");
            String author = sc.nextLine();
            // 因为在java中对象传递的是地址值，所以修改list中，map中的值也会进行修改
            bookList.get(temp).setName(name);
            bookList.get(temp).setKind(kind);
            bookList.get(temp).setPublishedTime(publishedTime);
            bookList.get(temp).setAuthor(author);
            System.out.println("修改成功，修改后的书本信息为：");
            System.out.println(bookList.get(temp));
        }
    }

    public void deleteBook() {
        System.out.println("请输入书本的编号");
        Integer id=Integer.valueOf(sc.nextLine());
        int temp = bookList.size();
        // 判断是否存在该书
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getId().equals(id)) {
                temp = i;
                break;
            }
        }
        if (temp == bookList.size()) {
            System.out.println("该书不存在");
        } else {
            Book book = bookList.get(temp);
            bookList.remove(book);
            bookMap.get(book.getKind()).remove(book);
            System.out.println("删除成功");
        }
    }

    public void showAllBook() {
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    public void borrowBook() {
        System.out.println("请输入书本的名称");
        // 判断书是否存在
        String name =String.valueOf(sc.nextLine());
        int temp = bookList.size();
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getName().equals(name)) {
                temp = i;
                break;
            }
        }
        if (temp == bookList.size()) {
            System.out.println("该书不存在");
        } else {
            // 借阅图书
            System.out.println("请输入归还的时间（按照 yyyy-mm-dd）的形式输入");
            String time = sc.nextLine();
            bookList.get(temp).setStatus(false);
            bookList.get(temp).setReturnTime(time);
            System.out.println("借阅成功！");
        }
    }

    public void returnBook(){
        System.out.println("请输入书本的名称");
        // 判断书是否存在
        String name =String.valueOf(sc.nextLine());
        int temp = bookList.size();
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getName().equals(name)) {
                temp = i;
                break;
            }
        }
        if (temp == bookList.size()) {
            System.out.println("该书不存在");
        } else {
            //归还图书
            bookList.get(temp).setStatus(true);
            bookList.get(temp).setReturnTime("");
            System.out.println("归还成功");
        }
    }
}
