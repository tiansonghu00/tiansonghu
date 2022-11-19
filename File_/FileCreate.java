package com.tian.File_;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class FileCreate {
    public static void main(String[] args) {

    }
    //方式1 new File(String pathname)
    @Test
    public void create01() {
        String filePath = "e:\\news1.txt";
        File file = new File(filePath);
        try {
            file.createNewFile();
            System.out.println("文件news1.txt创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    //方式2 new File(File parent,String child) 父目录文件+子路径
    public void create02() {
        File parentFile = new File("e:\\");
        String fileName = "news2.txt";
        //这里的file对象，在java程序中，只是一个对象
        //只有执行了createNewFile，才会真正在磁盘创建该文件
        File file = new File(parentFile, fileName);
        try {
            file.createNewFile();
            System.out.println("文件news2.txt创建成功");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    //方式3 new File(String parent,String child) 父目录+子路径
    public void create03() {
        String parentPath = "e:/";
        //String parentPath = "e:\\";
        String fileName = "news3.txt";
        File file = new File(parentPath,fileName);
        try {
            file.createNewFile();
            System.out.println("文件news3.txt创建成功");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

