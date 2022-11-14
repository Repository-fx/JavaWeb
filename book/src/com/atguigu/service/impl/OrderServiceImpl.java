package com.atguigu.service.impl;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.OrderDao;
import com.atguigu.dao.OrderItemDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.dao.impl.OrderDaoImpl;
import com.atguigu.dao.impl.OrderItemDaoImpl;
import com.atguigu.pojo.*;
import com.atguigu.service.OrderService;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @author fxStart
 * @create 2022-10-21-13:34
 */
public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao=new OrderDaoImpl();
    private OrderItemDao orderItemDao=new OrderItemDaoImpl();
    private BookDao bookDao=new BookDaoImpl();

    @Override
    public String createOrder(Cart cart, Integer userId) {
        System.out.println("OrderServiceImpl程序在线程【"+Thread.currentThread().getName()+"】中");

        //订单号，唯一性
        String orderId=System.currentTimeMillis()+""+userId;
        Order order=new Order(orderId, LocalDateTime.now(),cart.getTotalPrice(),0,userId);
        orderDao.saveOrder(order);

        //遍历购物车中的每一个商品项保存到订单项中
        for(CartItem item:cart.getItems().values()){
            orderItemDao.saveOrderItem(new OrderItem(null,item.getName(),item.getCount(),item.getPrice(),item.getTotalPrice(),orderId));
            Book book = bookDao.queryBookById(item.getId());
            book.setSales(book.getSales()+item.getCount());
            book.setStock(book.getStock()-item.getCount());
            bookDao.updateBook(book);
        }
        //清空购物车
        cart.clear();
        //返回订单号
        return orderId;
    }

    @Override
    public List<Order> showAllOrder() {
        return orderDao.queryOrders();
    }

    @Override
    public void sendOrder(String orderId) {
        orderDao.changeOrderStatus(orderId,1);
    }

    @Override
    public List<Order> showMyOrders(Integer userId) {
        return orderDao.queryOrdersByUserId(userId);
    }

    @Override
    public List<OrderItem> showOrderDetail(String orderId) {
        return orderItemDao.queryOrderItemsByOrderId(orderId);
    }

    @Override
    public void receiveOrder(String orderId) {
        orderDao.changeOrderStatus(orderId,2);
    }

    @Override
    public Order queryOrderById(String orderId) {
        return orderDao.queryOrderById(orderId);
    }
}
