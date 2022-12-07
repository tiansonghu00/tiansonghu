package com.tian.mhl.utils;

import java.sql.Connection;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException {
        //测试工具类
        System.out.println("输入一个整数");
        int i = Utility.readInt();
        System.out.println(i);
        //测试德鲁伊的工具类
        Connection connection = JDBCUtilsByDruid.getConnection();
        System.out.println(connection);
    }
}
