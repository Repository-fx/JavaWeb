package com.atguigu.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author fxStart
 * @create 2022-09-23-23:53
 */
public class ContextServlet1 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取ServletContext对象
//        ServletContext context = getServletConfig().getServletContext();
        ServletContext context = getServletContext();
        System.out.println("保存之前：Context1获取key1的值是："+context.getAttribute("key1"));
        context.setAttribute("key1","value1");
        System.out.println("Context1中获取数据key1的值是："+context.getAttribute("key1"));
        System.out.println("Context1中获取数据key1的值是："+context.getAttribute("key1"));
        System.out.println("Context1中获取数据key1的值是："+context.getAttribute("key1"));
        System.out.println("Context1中获取数据key1的值是："+context.getAttribute("key1"));
    }
}
