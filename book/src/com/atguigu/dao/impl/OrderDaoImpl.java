package com.atguigu.dao.impl;

import com.atguigu.dao.OrderDao;
import com.atguigu.pojo.Order;

import java.util.List;

/**
 * @author fxStart
 * @create 2022-10-21-11:55
 */
public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public int saveOrder(Order order) {
        String sql="insert into t_order(`order_id`,`create_time`,`price`,`status`,`user_id`)" +
                " values(?,?,?,?,?)";
        System.out.println("OrderDaoImpl程序在线程【"+Thread.currentThread().getName()+"】中");

        return update(sql,order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());
    }

    @Override
    public List<Order> queryOrders() {
        String sql="select `order_id` orderId,`create_time` createTime,`price`,`status`,`user_id` userId from t_order";
        return queryForList(Order.class, sql);
    }

    @Override
    public void changeOrderStatus(String orderId, int status) {
        String sql="update t_order set status=? where order_id=?";
        update(sql,status,orderId);
    }

    @Override
    public List<Order> queryOrdersByUserId(Integer userId) {
        String sql="select `order_id` orderId,`create_time` createTime,`price`,`status`,`user_id` userId from t_order where user_id=?";
        return queryForList(Order.class,sql,userId);
    }

    @Override
    public Order queryOrderById(String orderId) {
        String sql="select `order_id` orderId,`create_time` createTime,`price`,`status`,`user_id` userId from t_order where order_id=?";
        return queryForOne(Order.class,sql,orderId);
    }
}
