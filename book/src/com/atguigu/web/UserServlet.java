package com.atguigu.web;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import com.atguigu.utils.WebUtils;
import com.google.gson.Gson;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @author fxStart
 * @create 2022-10-02-14:54
 */
public class UserServlet extends BaseServlet {
    private UserService userService=new UserServiceImpl();
    /**
     * 处理登录的功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理登录的需求
        //1、获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User loginUser=userService.login(new User(null,username,password,null));
        //2、对输入参数进行判断是否成功登录
        if(loginUser==null){
            //登录失败
//            System.out.println("账号或密码错误");
            //把错误信息和回显的表单项信息，保存到Request域中
            req.setAttribute("msg","用户名或密码错误！");
            req.setAttribute("username",username);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }else{
            //登录成功
//            System.out.println("登录成功");
            //保存用户登录的信息到Session域中
            req.getSession().setAttribute("user",loginUser);
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }
    }

    /**
     * 注销
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void loginOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //关闭session
        req.getSession().invalidate();
        resp.sendRedirect("http://localhost:8080/book/index.jsp");
    }

        /**
         * 处理注册的功能
         * @param req
         * @param resp
         * @throws ServletException
         * @throws IOException
         */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取Session中的验证码
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        //删除Session中的验证码（确保每次都变化）
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        //处理注册的需求
        //1、获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

//        User user=new User();
//        WebUtils.copyParamToBean(req.getParameterMap(),user);
        User user= WebUtils.copyParamToBean(req.getParameterMap(),new User());

        //2、检查验证码是否正确，===写死，要求验证码为abcde
        if (token!=null && token.equalsIgnoreCase(code)) {
            //验证码正确
            //3、检查用户名是否可用
            if (userService.existsUsername(username)) {
                //存在，不可用
//                System.out.println("用户名[" + username + "]已存在，不可用！");
                req.setAttribute("msg","用户名已存在！");
                req.setAttribute("username",username);
                req.setAttribute("email",email);
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else {
                //不存在，可用
                userService.registUser(new User(null, username, password, email));
//                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
                resp.sendRedirect(req.getContextPath()+"/pages/user/regist_success.jsp");
            }
        } else {
//            System.out.println("验证码[" + code + "]错误");
            //把回显信息保存到Request域中
            req.setAttribute("msg","验证码错误！");
            req.setAttribute("username",username);
            req.setAttribute("email",email);
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }
    protected void ajaxExistsUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        boolean existsUsername = userService.existsUsername(username);
        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("existsUsername",existsUsername);
        Gson gson=new Gson();
        String json = gson.toJson(resultMap);
        resp.getWriter().write(json);
    }
}
