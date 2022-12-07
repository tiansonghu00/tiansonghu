package com.tian.jdbc;
import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class jdbc01 {
    //这是第一个jdbc程序，完成简单的操作
    public static void main(String[] args) throws SQLException {
        //注册驱动
        Driver driver = new Driver();
        //得到链接
        String url = "jdbc:mysql://localhost:3306/hu_db";
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","root");
        Connection connect = driver.connect(url,properties);
        //执行sql
        String sql = "insert into actor values(null,'李四','女','1978-09-10','130')";
        //Statement用于执行静态sql语句并返回其生成的结果的对象
        Statement statement = connect.createStatement();
        int rows = statement.executeUpdate(sql);//如果是dml语句，返回的就是影响行数
        System.out.println(rows > 0?"成功":"失败");
        //关闭链接
        statement.close();
        connect.close();
    }
}
