package com.tian.buffered;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class BufferedReader_ {
    public static void main(String[] args) throws Exception {
        //演示BufferedReader使用
        String filePath = "e:\\note.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        //读取
        String line;//按行读取，效率高
        //当返回空时，表示读取完毕
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        //关闭流,只需要关闭外层就可以，底层会自动去关闭节点流
        bufferedReader.close();
    }
}
    /*
    public void close() throws IOException {
        synchronized (lock) {
            if (in == null)
                return;
            try {
                in.close();//就是我们传入的new FileReader()
            } finally {
                in = null;
                cb = null;
            }
        }
    }
         */