package com.tian.File_;

import org.testng.annotations.Test;

import java.io.File;

public class FileInformation {
    public static void main(String[] args) {

    }
    //获取文件的信息
    @Test
    public void info() {
        //先创建文件对象
        File file = new File("e:\\news1.txt");
        //调用相应方法，得到对应信息
        System.out.println("文件名=" + file.getName());
        //得到文件绝对路径
        System.out.println("文件绝对路径=" + file.getAbsolutePath());
        //文件父级目录
        System.out.println("文件父级目录" + file.getParent());
        //得到文件的大小
        System.out.println("文件大小=" + file.length());
        //判断文件是否存在
        System.out.println("文件是否存在=" + file.exists());
        //是不是一个文件
        System.out.println("是不是一个文件=" + file.isFile());
        //是不是一个目录
        System.out.println("是不是一个目录=" + file.isDirectory());
    }
}
