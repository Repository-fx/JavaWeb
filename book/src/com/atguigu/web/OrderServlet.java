package com.atguigu.web;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.Order;
import com.atguigu.pojo.OrderItem;
import com.atguigu.pojo.User;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.OrderServiceImpl;
import com.atguigu.utils.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author fxStart
 * @create 2022-10-21-14:20
 */
public class OrderServlet extends BaseServlet{
    private OrderService orderService=new OrderServiceImpl();

    /**
     * 生成订单
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //先获取cart购物车对象
        Cart cart=(Cart)req.getSession().getAttribute("cart");
        //获取userId
        User loginUser = (User) req.getSession().getAttribute("user");
        if(loginUser==null){
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            return;
        }

        System.out.println("OrderServlet程序在线程【"+Thread.currentThread().getName()+"】中");

        Integer userId = loginUser.getId();
        String orderId= orderService.createOrder(cart,userId);
//        req.setAttribute("orderId",orderId);
        req.getSession().setAttribute("orderId",orderId);
        //请求转发
//        req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req,resp);
        //请求重定向
        resp.sendRedirect(req.getContextPath()+"/pages/cart/checkout.jsp");
    }

    protected void showAllOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Order> orders = orderService.showAllOrder();
        req.getSession().setAttribute("orders",orders);
        resp.sendRedirect(req.getContextPath()+"/pages/manager/order_manager.jsp");
    }
    protected void sendOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        orderService.sendOrder(orderId);
        //如果发送之后直接跳回去，显示的依然是之前保存的orders
//        req.getRequestDispatcher("/pages/manager/order_manager.jsp");
//        resp.sendRedirect(req.getContextPath()+"/pages/manager/order_manager.jsp");
//        resp.sendRedirect(req.getHeader("Referer"));
        showAllOrder(req,resp);
    }
    protected void showMyOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User loginUser = (User) req.getSession().getAttribute("user");
        if(loginUser==null){
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            return;
        }
        Integer id = loginUser.getId();
        List<Order> orders = orderService.showMyOrders(id);
        req.getSession().setAttribute("myOrders",orders);
        resp.sendRedirect(req.getContextPath()+"/pages/order/order.jsp");
    }

    protected void showOrderDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        List<OrderItem> orderItems = orderService.showOrderDetail(orderId);
        Order order = orderService.queryOrderById(orderId);

        req.getSession().setAttribute("order",order);
        req.getSession().setAttribute("orderItems",orderItems);
//        req.getRequestDispatcher("/pages/order/order_detail.jsp").forward(req,resp);
//        req.getSession().setAttribute("orderItems",orderItems);
        resp.sendRedirect(req.getContextPath()+"/pages/order/order_detail.jsp");
    }

    protected void receiveOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        orderService.receiveOrder(orderId);
        showOrderDetail(req,resp);
    }
}
