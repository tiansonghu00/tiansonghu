package com.tian.properties_;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Properties03 {
    public static void main(String[] args) throws IOException {
        //Properties类来创建，修改配置文件
        Properties properties = new Properties();
        //创建
        properties.setProperty("charset","utf8");
        properties.setProperty("user","杰克");//保存的是该中文的unicode码
        properties.setProperty("pwd","123456");
        properties.setProperty("pwd","888888");//修改就是覆盖原有的
        //将键值对存储在文件中
        properties.store(new FileOutputStream("src\\mysql2.properties"),null);//null是注解/注释
        System.out.println("保存配置文件成功");
    }
}
