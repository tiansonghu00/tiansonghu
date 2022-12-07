package com.tian.datasource;

import com.tian.utils.JDBCUtilsByDruid;
import jdk.nashorn.internal.scripts.JD;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DBUtils_USE {
    //使用Apache——DBUtils工具类+Druid完成对表的CRUD操作
    @Test
    public void testQueryMany() throws SQLException {
        //得到连接
        Connection connection = JDBCUtilsByDruid.getConnection();
        //创建QueryRunner
        QueryRunner queryRunner = new QueryRunner();
        //就可以执行相关的方法，返回ArrayList结果集
        String sql = "select * from actor where id >= ?";
        //1 就是给sql语句中的？赋值大的，可以有多个值，因为是可变参数
        List<Actor> list = queryRunner.query(connection, sql, new BeanListHandler<>(Actor.class), 1);
        System.out.println("输出集合的信息");
        for (Actor actor :list) {
            System.out.println(actor);
        }
        JDBCUtilsByDruid.close(null,null,connection);
    }
    //演示Apache-DBUtils + Druid完成返回的结果是单行记录（单个对象）
    @Test
    public void testQuerySingle() throws SQLException {
        //得到连接
        Connection connection = JDBCUtilsByDruid.getConnection();
        //创建QueryRunner
        QueryRunner queryRunner = new QueryRunner();
        //就可以执行相关的方法，返回ArrayList结果集
        String sql = "select id,name from actor where id >= ?";
        Actor actor = queryRunner.query(connection, sql, new BeanHandler<>(Actor.class), 3);
        System.out.println(actor);
        JDBCUtilsByDruid.close(null,null,connection);
    }
    //演示Apache-dbutils + druid 完成查询结果是单行单列-返回的就是object
    @Test
    public void testScalar() throws SQLException {
        Connection connection = JDBCUtilsByDruid.getConnection();
        //创建QueryRunner
        QueryRunner queryRunner = new QueryRunner();
        //就可以执行相关的方法，返回ArrayList结果集
        String sql = "select name from actor where id = ?";
        Object obj = queryRunner.query(connection, sql, new ScalarHandler(), 3);
        System.out.println(obj);
        JDBCUtilsByDruid.close(null,null,connection);
    }
    @Test
    //演示Apache-dbutils + druid 完成dml
    public void testDML() throws SQLException {
        Connection connection = JDBCUtilsByDruid.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "update actor set name = ? where id = ?";
        //String sql = "insert into actor values(null,‘张三’,'男'，'1987-06-25','652')"
        int affectedRow = queryRunner.update(connection,sql,"张三丰",1);
        System.out.println(affectedRow > 0 ? "执行成功" :"执行没有影响到表");
        JDBCUtilsByDruid.close(null,null,connection);
    }
}
