package com.tian.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JdbcHomework02 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
//        System.out.println("请输入需要的用户名");
//        Scanner scanner = new Scanner(System.in);
//        String inUser = scanner.nextLine();
//        System.out.println("请输入新的密码");
//        scanner = new Scanner(System.in);
//        String inPsd = scanner.nextLine();
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/mysql.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");

        Class.forName(driver);

        Connection connection = DriverManager.getConnection(url, user, password);
        //String sqlStr = "insert into admin values (?,?)";
        String sqlStr = "select name, pwd from admin";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlStr);
        //preparedStatement.setString(1, inUser);
        //preparedStatement.setString(2, inPsd);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String name = resultSet.getString(1);
            String pwd = resultSet.getString(2);
            System.out.println(name + "\t" + pwd + "\t");
        }
        preparedStatement.close();
        connection.close();
    }
}
