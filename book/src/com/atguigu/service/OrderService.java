package com.atguigu.service;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.Order;
import com.atguigu.pojo.OrderItem;

import java.util.List;

/**
 * @author fxStart
 * @create 2022-10-21-13:32
 */
public interface OrderService {
    public String createOrder(Cart cart,Integer userId);
    public List<Order> showAllOrder();
    public void sendOrder(String orderId);
    public List<Order> showMyOrders(Integer userId);
    public List<OrderItem> showOrderDetail(String orderId);
    public void receiveOrder(String orderId);
    public Order queryOrderById(String orderId);
}
