package com.tian.homework19;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Homework01 {
    public static void main(String[] args) throws IOException {
        /*
        判断e盘下是否有文件夹mytemp,如果没有，就创建
        在该文件夹下，创建文件hello.txt,写入hello，world已存在就提示
         */
        String directoryPath = "e:\\mytemp";
        File file = new File(directoryPath);
        if (!file.exists()) {
            if (file.mkdirs()) {
                System.out.println("创建成功" + directoryPath);
            } else {
                System.out.println("创建失败");
            }
        }
        String filePath = directoryPath + "\\hello.txt";
        file = new File(filePath);
        if (!file.exists()) {
            if (file.createNewFile()) {
                System.out.println("创建成功" + filePath);
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
                bufferedWriter.write("hello world");
            } else {
                System.out.println("创建失败");
            }
        } else {
            System.out.println("文件存在");
        }
    }
}
