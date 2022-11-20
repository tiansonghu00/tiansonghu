package com.tian.buffered;

import java.io.*;

public class BufferedCopy_2 {
    //使用BufferedInputStream和bufferedOutputStream
    public static void main(String[] args) throws IOException {
        String srcFilePath = "e:\\6.jpg";
        String destFilePath = "d:\\8.jpg";
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        bufferedInputStream = new BufferedInputStream(new FileInputStream(srcFilePath));
        bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(destFilePath));
        byte[] buff = new byte[1024];
        int readLen = 0;
        while ((readLen = bufferedInputStream.read(buff)) != -1) {
            bufferedOutputStream.write(buff,0,readLen);
        }
        //关闭外层流
        if (bufferedInputStream != null) {
            bufferedInputStream.close();
        }
        if (bufferedOutputStream != null) {
            bufferedOutputStream.close();
        }
    }
}
