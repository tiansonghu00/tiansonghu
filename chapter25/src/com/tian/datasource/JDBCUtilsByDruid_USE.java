package com.tian.datasource;

import com.tian.utils.JDBCUtilsByDruid;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.ArrayList;

public class JDBCUtilsByDruid_USE {
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
            connection = JDBCUtilsByDruid.getConnection();
            System.out.println(connection.getClass());
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
            JDBCUtilsByDruid.close(set,preparedStatement,connection);
        }
    }
    //老师的土方法解决resultSet封装得到ArrayList

    public ArrayList<Actor> testSelectToArrayList() {
        //得到连接
        Connection connection = null;
        //组织一个sql
        String sql = "select * from actor where id >= ?";
        //创建PreparedStatement对象
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        ArrayList<Actor> list = new ArrayList<Actor>();
        try {
            connection = JDBCUtilsByDruid.getConnection();
            System.out.println(connection.getClass());
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,1);
            set = preparedStatement.executeQuery();
            //遍历结果集
            while (set.next()) {
                int id = set.getInt("id");
                String name = set.getString("name");
                String sex = set.getString("sex");
                Date borndate = set.getDate("borndate");
                String phone = set.getString("phone");
                //把得到的resultSet的记录，封装到actor对象，放入到list集合
                list.add(new Actor(id,name,sex,borndate,phone));
            }
            System.out.println("list=" + list);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtilsByDruid.close(set,preparedStatement,connection);
        }
        //因为ArrayList和connection没有任何关联，所以该集合可以复用
        return list;
    }
}
