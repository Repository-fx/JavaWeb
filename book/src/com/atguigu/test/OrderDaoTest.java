package com.atguigu.test;

import com.atguigu.dao.OrderDao;
import com.atguigu.dao.impl.OrderDaoImpl;
import com.atguigu.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author fxStart
 * @create 2022-10-21-12:38
 */
public class OrderDaoTest {

    @Test
    public void saveOrder() {
        OrderDao orderDao=new OrderDaoImpl();
        orderDao.saveOrder(new Order("1234567sdghns89",LocalDateTime.now(),new BigDecimal(100),0,1));
    }

    @Test
    public void queryOrders() {
        OrderDao orderDao=new OrderDaoImpl();
        List<Order> orders = orderDao.queryOrders();
        for(Order order:orders){
            System.out.println(order);
        }
    }

    @Test
    public void changeOrderStatus() {
        OrderDao orderDao=new OrderDaoImpl();
        orderDao.changeOrderStatus("16663331426331",1);
    }

    @Test
    public void queryOrdersByUserId() {
        OrderDao orderDao=new OrderDaoImpl();
        List<Order> orders = orderDao.queryOrdersByUserId(1);
        for(Order order:orders){
            System.out.println(order);
        }
    }

    @Test
    public void queryOrderById(){
        OrderDao orderDao=new OrderDaoImpl();
        Order order = orderDao.queryOrderById("16663331426331");
        System.out.println(order);
    }
}