package com.tian.properties_;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Properties02 {
    //使用Properties类来读取mysql.properties文件
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        //加载指定配置文件
        properties.load(new FileReader("src\\mysql.properties"));
        //那键值对显示在控制台
        properties.list(System.out);
        //根据key获取对应的值
        String user = properties.getProperty("user");
        String pwd = properties.getProperty("pwd");
        System.out.println("用户名=" + user);
        System.out.println("密码=" + pwd);
    }
}
