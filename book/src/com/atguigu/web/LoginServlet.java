package com.atguigu.web;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author fxStart
 * @create 2022-09-27-19:02
 */
public class LoginServlet extends HttpServlet {
    private UserService userService=new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //2、对输入参数进行判断是否成功登录
        if(userService.login(new User(null,username,password,null))==null){
            //登录失败
//            System.out.println("账号或密码错误");
            //把错误信息和回显的表单项信息，保存到Request域中
            req.setAttribute("msg","用户名或密码错误！");
            req.setAttribute("username",username);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }else{
            //登录成功
            System.out.println("登录成功");
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }
    }
}
