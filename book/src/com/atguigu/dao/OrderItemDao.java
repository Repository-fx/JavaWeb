package com.atguigu.dao;

import com.atguigu.pojo.OrderItem;

import java.util.List;

/**
 * @author fxStart
 * @create 2022-10-20-23:42
 */
public interface OrderItemDao {
    public int saveOrderItem(OrderItem orderItem);
    public List<OrderItem> queryOrderItemsByOrderId(String orderId);
}
