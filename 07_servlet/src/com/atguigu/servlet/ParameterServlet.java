package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author fxStart
 * @create 2022-09-24-17:12
 */
public class ParameterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("=============Get===============");
        //获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String[] hobbies = req.getParameterValues("hobby");

        System.out.println("用户名=>"+username);
        System.out.println("密码=>"+password);
        System.out.println("爱好=>"+ Arrays.toString(hobbies));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求体的字符集为UTF-8，从而解决post请求的中文乱码问题
        //要在获取请求参数之前调用才有效
        req.setCharacterEncoding("UTF-8");
        System.out.println("=============POST===============");
        //获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String[] hobbies = req.getParameterValues("hobby");

        System.out.println("用户名=>"+username);
        System.out.println("密码=>"+password);
        System.out.println("爱好=>"+ Arrays.toString(hobbies));
    }
}
