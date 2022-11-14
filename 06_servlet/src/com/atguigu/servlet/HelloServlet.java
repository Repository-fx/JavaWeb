package com.atguigu.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author fxStart
 * @create 2022-09-22-16:11
 */
public class HelloServlet implements Servlet {
    public HelloServlet() {
        System.out.println("1.构造器方法");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2.init初始化");

//        1、可以获取 Servlet 程序的别名 servlet-name的值
        System.out.println("HelloServlet程序的别名是："+servletConfig.getServletName());
//        2、获取初始化参数 init-param
        System.out.println("HelloServlet初始化参数");
        System.out.println("初始化参数username的值是："+servletConfig.getInitParameter("username"));
        System.out.println("初始化参数url的值是："+servletConfig.getInitParameter("url"));
//        3、获取 ServletContext 对象
        System.out.println(servletConfig.getServletContext());

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * service方法是专门用来处理请求和响应的
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("3.service Hello Servlet 被访问了");
        //类型转换，子类HttpServletRequest有getMethod方法
        HttpServletRequest httpServletRequest= (HttpServletRequest) servletRequest;
        String method = httpServletRequest.getMethod();
//        System.out.println(method);
        if("GET".equals(method)){
            doGet();
        }else if("POST".equals(method)){
            doPost();
        }
    }
    public void doGet(){
        System.out.println("get请求做的事");
    }

    public void doPost(){
        System.out.println("post请求做的事");
    }
    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4.destroy 销毁方法");
    }
}
