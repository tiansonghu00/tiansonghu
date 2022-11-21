package com.tian.properties_;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Properties01 {
    public static void main(String[] args) throws IOException {
        //读取mysql.properties
        BufferedReader br = new BufferedReader(new FileReader("src\\mysql.properties"));
        String line = "";
        while ((line = br.readLine()) != null) {
            String split[] = line.split("=");
            System.out.println(split[0] + "值是：" + split[1]);
        }
        br.close();
    }
}
