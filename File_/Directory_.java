package com.tian.File_;

import org.testng.annotations.Test;

import java.io.File;

public class Directory_ {
    public static void main(String[] args) {

    }
    //判断文件是否存在，如果存在就删除
    @Test
    public void m1() {
        String filePath = "e:\\news1.txt";
        File file = new File(filePath);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println(filePath + "删除成功");
            } else {
                System.out.println(filePath + "删除失败");
            }
        } else {
            System.out.println("文件不存在");
        }
    }
    //判断文件夹是否存在，存在就删除，否则提示不存在
    @Test
    public void m2() {
        String filePath = "e:\\demo";
        File file = new File(filePath);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println(filePath + "删除成功");
            } else {
                System.out.println(filePath + "删除失败");
            }
        } else {
            System.out.println("目录不存在");
        }
    }
    //判断目录是否存在，存在就提示已存在，否则就创建
    @Test
    public void m3() {
        String directoryPath = "e:\\demo\\a";
        File file = new File(directoryPath);
        if (file.exists()) {
            System.out.println("目录存在");
        } else {
            if (file.mkdirs()) {
                System.out.println(directoryPath + "创建成功");
            } else {
                System.out.println(directoryPath + "创建失败");
            }
        }
    }
}
