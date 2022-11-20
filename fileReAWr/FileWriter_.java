package com.tian.fileReAWr;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriter_ {
    public static void main(String[] args) {
        String filePath = "e:\\note.txt";
        //创建FileWriter对象
        FileWriter fileWriter = null;
        char[] chars = {'a','h','g','d','f'};
        String str = "qwer";
        try {
            fileWriter = new FileWriter(filePath);
            //write(int):写入单个字符
            fileWriter.write('s');
            //write(char[]):写入指定数组
            fileWriter.write(chars);
            //write(char[],off,;len):写入指定数组指定部分
            fileWriter.write("阿斯顿".toCharArray(),1,2);
            //write(String)写入整个字符串
            fileWriter.write(str);
            //write(string,off,;len):写入字符串指定部分
            fileWriter.write("风雨火候，定见彩虹",1,2);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
