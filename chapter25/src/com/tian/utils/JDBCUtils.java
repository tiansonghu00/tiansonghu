package com.tian.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * JDBC工具包:完成mysql的连接和关闭资源
 */
public class JDBCUtils {
    // 因为只需要一份，所以做成静态的
    /**
     * 用户名
     */
    private static String user;
    /**
     * 密码
     */
    private static String password;
    /**
     * url
     */
    private static String url;
    /**
     * driver
     */
    private static String driver;

    // 在静态代码块初始化
    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/mysql.properties"));
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            url = properties.getProperty("url");
            driver = properties.getProperty("driver");
            Class.forName(driver);
        } catch (IOException | ClassNotFoundException e) {
            // 在实际开发中，这样处理
            // 1.将编译异常转换成运行异常
            // 2.调用者可以选择捕获异常，或者默认处理
            throw new RuntimeException(e);
        }
    }
    /***
     * 连接数据库,返回Connection
     * @Param No such property: code for class: Script1
     * @return java.sql.Connection
     **/
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            // 在实际开发中，这样处理
            // 1.将编译异常转换成运行异常
            // 2.调用者可以选择捕获异常，或者默认处理
            throw new RuntimeException(e);
        }
    }

    /***
     * 关闭相关资源
     * @Param * @param resultSet
     * @param statement
     * @param connection
     * @return void
     **/
    public static void close(ResultSet resultSet, Statement statement, Connection connection) {
        // 1. ResultSet 结果集
        // 2. Statement PreparedStatement
        // 3. Connection
        // 4. 如果需要关闭资源，就传入资源，否则就传入空
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

