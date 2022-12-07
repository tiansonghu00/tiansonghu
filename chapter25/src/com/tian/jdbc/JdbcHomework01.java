package com.tian.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcHomework01 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        //在4的基础上，增加配置文件，连接更灵活
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        //获取相关的值
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        String sql = "create table news ( id int, name varchar(32))";
        String sql1 = "insert into news values(1, '张三')";
        String sql2 = "insert into news values(2, '李四')";
        String sql3 = "update  news set name = '王五' where id = 1";
        String sql4 = "delete from news where id = 2";
        int rows = statement.executeUpdate(sql3);
        System.out.println(rows > 0 ? "成功" : "失败");
        statement.close();
        connection.close();
    }
}
