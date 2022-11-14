package com.atguigu.test;

import com.atguigu.dao.OrderItemDao;
import com.atguigu.dao.impl.OrderItemDaoImpl;
import com.atguigu.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author fxStart
 * @create 2022-10-21-12:42
 */
public class OrderItemDaoTest {

    @Test
    public void saveOrderItem() {
        OrderItemDao orderItemDao=new OrderItemDaoImpl();
        orderItemDao.saveOrderItem(new OrderItem(null,"java从入门到精通",1,new BigDecimal(100),new BigDecimal(100),"123456789"));
        orderItemDao.saveOrderItem(new OrderItem(null,"javaScript从入门到精通",1,new BigDecimal(100),new BigDecimal(200),"123456789"));
        orderItemDao.saveOrderItem(new OrderItem(null,"十二道锋味",3,new BigDecimal(50),new BigDecimal(150),"123456789"));
    }

    @Test
    public void queryOrderItemsByOrderId() {
        OrderItemDao orderItemDao=new OrderItemDaoImpl();
        List<OrderItem> orderItems = orderItemDao.queryOrderItemsByOrderId("16663331426331");
        for(OrderItem orderItem:orderItems){
            System.out.println(orderItem);
        }
    }
}