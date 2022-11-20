package com.tian.buffered;

import java.io.*;

public class BufferedCopy_ {
    public static void main(String[] args) throws IOException {
        String srcFilePath = "e:\\ok.txt";
        String destFilePath = "d:\\ok1.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(srcFilePath));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(destFilePath));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            //每读一行，就写入
            bufferedWriter.write(line);
            //插入换行
            bufferedWriter.newLine();
        }
        if (bufferedReader != null) {
            bufferedReader.close();
        }
        if (bufferedWriter != null) {
            bufferedWriter.close();
        }
    }
}
