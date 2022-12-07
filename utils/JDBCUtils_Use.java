package com.tian.utils;

import org.testng.annotations.Test;

import java.sql.*;

public class JDBCUtils_Use {
    public static void main(String[] args) {

    }
    @Test
    public void testSelect() {
        //得到连接
        Connection connection = null;
        //组织一个sql
        String sql = "select  * from actor";
        //创建PreparedStatement对象
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            set = preparedStatement.executeQuery();
            //遍历结果集
            while (set.next()) {
                int id = set.getInt("id");
                String name = set.getString("name");
                String sex = set.getString("sex");
                Date borndate = set.getDate("borndate");
                String phone = set.getString("phone");
                System.out.println(id + "\t" + name + "\t" + sex + "\t" + borndate + "\t" + phone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(set,preparedStatement,connection);
        }
    }
    //演示如何使用JDBCUtils，完成dml和select
    @Test
    public void testDML() {
        //得到连接
        Connection connection = null;
        //组织一个sql
        String sql = "update actor set name = ? where id = ?";
        //创建PreparedStatement对象
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            //给占位符赋值
            preparedStatement.setString(1,"jack");
            preparedStatement.setInt(2,1);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null,preparedStatement,connection);
        }
    }
}
