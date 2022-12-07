package com.tian.transaction_;

import com.tian.utils.JDBCUtils;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Transaction_ {
    //演示jdbc中如何使用事务
    @Test
    public void noTransaction() {
        //操作转账事务
        //得到连接
        Connection connection = null;
        //组织一个sql
        String sql = "update account set balance = balance - 100 where id = 1";
        String sql1 = "update account set balance = balance + 100 where id = 2";
        //创建PreparedStatement对象
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            int i = 1 / 0;//抛出异常
            preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null,preparedStatement,connection);
        }
    }
    @Test
    public void Transaction() {
        //操作转账事务
        //得到连接
        Connection connection = null;
        //组织一个sql
        String sql = "update account set balance = balance - 100 where id = 1";
        String sql1 = "update account set balance = balance + 100 where id = 2";
        //创建PreparedStatement对象
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();
            //关闭自动提交
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            int i = 1 / 0;//抛出异常
            preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (Exception e) {
            //进行回滚
            System.out.println("执行发生了异常，回滚，撤销执行的sql语句");
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null,preparedStatement,connection);
        }
    }
}
