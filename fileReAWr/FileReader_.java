package com.tian.fileReAWr;

import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReader_ {
    public static void main(String[] args) {
        String filePath = "e:\\a.txt";
        FileReader fileReader = null;
        int data = 0;
        //创建FileReader对象
        try {
            fileReader = new FileReader(filePath);
            //循环读取，使用read
            while ((data = fileReader.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    //用字符数组读取，更高效
    @Test
    public void readFile() {
        String filePath = "e:\\a.txt";
        FileReader fileReader = null;
        int readLen = 0;
        char[] buf = new char[8];
        //创建FileReader对象
        try {
            fileReader = new FileReader(filePath);
            //循环读取，使用read(buf),返回的是实际读取到的字符数
            while ((readLen = fileReader.read(buf)) != -1) {
                System.out.print(new String(buf,0,readLen));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
