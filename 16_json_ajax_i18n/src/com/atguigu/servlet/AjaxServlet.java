package com.atguigu.servlet;

import com.atguigu.pojo.Person;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author fxStart
 * @create 2022-10-26-20:54
 */
public class AjaxServlet extends BaseServlet{

    protected void javaScriptAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Ajax请求过来了");

        Person person=new Person(1,"阿伦");
        Gson gson=new Gson();
        String personJsonString = gson.toJson(person);
        resp.getWriter().write(personJsonString);
    }
    protected void jQueryAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jQueryAjax == 方法调用了");

        Person person=new Person(1,"阿伦");
        Gson gson=new Gson();
        String personJsonString = gson.toJson(person);
        resp.getWriter().write(personJsonString);
    }
    protected void jQuerySerialize(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jQuerySerialize == 方法调用了");
        System.out.println("用户名："+req.getParameter("username"));
        System.out.println("密码："+req.getParameter("password"));

        Person person=new Person(1,"阿伦");
        Gson gson=new Gson();
        String personJsonString = gson.toJson(person);
        resp.getWriter().write(personJsonString);
    }
}
