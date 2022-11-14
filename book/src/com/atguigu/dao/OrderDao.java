package com.atguigu.dao;

import com.atguigu.pojo.Order;

import java.util.List;

/**
 * @author fxStart
 * @create 2022-10-20-23:38
 */
public interface OrderDao {
    public int saveOrder(Order order);
    public List<Order> queryOrders();
    public void changeOrderStatus(String orderId,int status);
    public List<Order> queryOrdersByUserId(Integer userId);
    public Order queryOrderById(String orderId);
}
