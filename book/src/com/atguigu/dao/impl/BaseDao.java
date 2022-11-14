package com.atguigu.dao.impl;

import com.atguigu.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * BaseDao用于复用代码，写了一些方法给子类用
 *
 * @author fxStart
 * @create 2022-09-26-19:39
 */
public abstract class BaseDao {
    //使用DBUtils操作数据库
    private QueryRunner queryRunner = new QueryRunner();

    /**
     * update() 方法用于执行 insert update delete方法
     *
     * @return 如果返回-1，说明执行失败，返回其它说明影响了行数
     */
    public int update(String sql, Object... args) {
        System.out.println("BaseDao程序在线程【"+Thread.currentThread().getName()+"】中");

        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.update(conn, sql, args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return -1;
    }

    /**
     * 查询返回一条javaBean的sql语句
     *
     * @param type 返回的对象类型
     * @param sql  查询的sql语句
     * @param args sql对应的参数值
     * @param <T>  返回类型的泛型
     * @return
     */
    public <T> T queryForOne(Class<T> type, String sql, Object... args) {
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.query(conn, sql, new BeanHandler<T>(type), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     * 查询返回多个JavaBean的sql语句
     *
     * @param type
     * @param sql
     * @param args
     * @param <T>
     * @return
     */
    public <T> List<T> queryForList(Class<T> type, String sql, Object... args) {
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.query(conn, sql, new BeanListHandler<T>(type), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     * 执行查询返回一个数据的sql语句
     *
     * @param sql
     * @param args
     * @return
     */
    public Object queryForSingleValue(String sql, Object... args) {
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.query(conn, sql, args, new ScalarHandler());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
