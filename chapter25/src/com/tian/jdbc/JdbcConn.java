package com.tian.jdbc;

import com.mysql.cj.jdbc.Driver;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcConn {
    //数据库五种连接方式
    @Test
    public void connect01() throws SQLException {
        Driver driver = new Driver();
        String url = "jdbc:mysql://localhost:3306/hu_db";
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","root");
        Connection connect = driver.connect(url,properties);
        System.out.println("方法1=" + connect);
    }
    @Test
    public void connect02() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        //使用反射加载Driver类，动态加载，更灵活，减少依赖性
        Class clazz = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();
        String url = "jdbc:mysql://localhost:3306/hu_db";
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","root");
        Connection connect = driver.connect(url,properties);
        System.out.println("方法2=" + connect);
    }
    @Test
    public void connect03() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        //使用DriverManager代替Driver
        Class clazz = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();
        String url = "jdbc:mysql://localhost:3306/hu_db";
        String user = "root";
        String password = "root";
        DriverManager.registerDriver(driver);
        Connection connect = DriverManager.getConnection(url,user,password);
        System.out.println("方法3=" + connect);
    }
    @Test
    public void connect04() throws ClassNotFoundException, SQLException {
        //使用Class.forName自动完成注册驱动，使用反射加载了Driver类
        //这种方法获得连接，是使用最多的
        Class.forName("com.mysql.cj.jdbc.Driver");//可省略
        String url = "jdbc:mysql://localhost:3306/hu_db";
        String user = "root";
        String password = "root";
        Connection connect = DriverManager.getConnection(url,user,password);
        System.out.println("方法4=" + connect);
    }
    @Test
    public void connect05() throws IOException, ClassNotFoundException, SQLException {
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
        System.out.println("方法5=" + connection);
    }
}
