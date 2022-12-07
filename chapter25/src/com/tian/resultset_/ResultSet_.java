package com.tian.resultset_;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class ResultSet_ {
    //演示select语句放回ResultSet，并取出结果
    public static void main(String[] args) throws Exception{
        //配置文件，连接更灵活
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        //获取相关的值
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        Class.forName("com.mysql.cj.jdbc.Driver");
        //得到链接
        Connection connection = DriverManager.getConnection(url, user, password);
        //得到statement
        Statement statement = connection.createStatement();
        //组织sql
        String sql = "select id,name,sex,borndate from actor";
        ResultSet resultSet = statement.executeQuery(sql);
        //使用while取出数据
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getNString(2);
            String sex = resultSet.getNString(3);
            Date date = resultSet.getDate(4);
            System.out.println(id + "\t" + name + "\t" + sex + "\t" + date);
        }
        //关闭连接
        resultSet.close();
        statement.close();
        connection.close();
    }
}
