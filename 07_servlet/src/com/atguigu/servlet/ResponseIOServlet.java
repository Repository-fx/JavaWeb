package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author fxStart
 * @create 2022-09-25-14:29
 */
public class ResponseIOServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决post请求乱码
//        req.setCharacterEncoding("utf-8");

        //设置服务器响应的字符编码
//        resp.setCharacterEncoding("UTF-8");
        //设置客户端显示的字符编码
//        resp.setHeader("Content-Type","text/html; charset=UTF-8");

        //同时设置服务器和客户端都使用UTF-8字符集，还设置了响应头
        //此方法一定要在获取流对象之前设置才有效
        resp.setContentType("text/html;charset=UTF-8");

        //通过响应头，设置浏览器也使用utf-8字符集

//        System.out.println("请求字符集："+req.getCharacterEncoding());
        System.out.println("响应字符集："+resp.getCharacterEncoding());
        //要求：往客户端回传 字符串 数据
        PrintWriter writer = resp.getWriter();
        writer.write("快点学完");
    }
}
