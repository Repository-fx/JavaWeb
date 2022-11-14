package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author fxStart
 * @create 2022-09-25-16:03
 */
public class Response1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Response1");
        //方式一
        //设置响应状态码302，表示重定向
//        resp.setStatus(302);
        //设置响应头，说明新的Response在哪
//        resp.setHeader("Location","http://localhost:8080/07_servlet/response2");
//        resp.setHeader("Location","http://www.baidu.com");

        //方式二
        resp.sendRedirect("http://localhost:8080/07_servlet/response2");
    }
}
