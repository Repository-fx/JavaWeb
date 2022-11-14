package com.atguigu.servlet;

import com.atguigu.utils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author fxStart
 * @create 2022-10-13-17:53
 */
public class CookieServlet extends BaseServlet {
    //cookie对象的创建
    protected void createCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建cookie对象
        Cookie cookie1 = new Cookie("key1", "value1");
        //通知客户端保存cookie
        resp.addCookie(cookie1);
        Cookie cookie2 = new Cookie("key2", "value2");
        resp.addCookie(cookie2);
        Cookie cookie3 = new Cookie("key3", "value3");
        resp.addCookie(cookie3);
        resp.getWriter().write("Cookie创建成功");
    }

    //cookie对象的获取
    protected void getCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();

        for (Cookie cookie : cookies) {
            //getName方法方法返回Cookie的key（名）
            //getValue方法返回Cookie的value值
            resp.getWriter().write("Cookie[" + cookie.getName() + "=" + cookie.getValue() + "]<br/>");
        }

        Cookie iWantCookie = CookieUtils.findCookie("key1", cookies);
        resp.getWriter().write("找到了对应的Cookie[" + iWantCookie.getName() + "=" + iWantCookie.getValue() + "]<br/>");
    }

    //Cookie值的修改
    protected void updateCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //第一种方案是：创建一个同名的Cookie对象，在构造器中赋予新的Cookie值，然后addCookie
        Cookie cookie = new Cookie("key1", "new Value1");
        resp.addCookie(cookie);
        resp.getWriter().write("key1的value值已经修改好了<br/>");

        //第二种方案是：查找到需要修改的Cookie对象，调用setValue方法赋予新的Cookie值，最后addCookie通知客户端保存修改
        Cookie key2 = CookieUtils.findCookie("key2", req.getCookies());
        if (key2 != null) {
            key2.setValue("new Value2");
            resp.addCookie(key2);
            resp.getWriter().write("key2的value值已经修改好了");
        }
    }

    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("defaultLife", "defaultLife");
        //设置存活时间
        cookie.setMaxAge(-1);
        resp.addCookie(cookie);
    }

    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie key3 = CookieUtils.findCookie("key3", req.getCookies());
        if (key3 != null) {
            key3.setMaxAge(0); //表示马上删除
            resp.addCookie(key3);
            resp.getWriter().write("key3的Cookie已经被删除");
        }
    }

    protected void life3600(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("life3600", "life3600");
        cookie.setMaxAge(3600);//设置cookie在一小时之后被删除
        resp.addCookie(cookie);
        resp.getWriter().write("已经创建了一个存活一小时的Cookie");
    }

    protected void testPath(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie=new Cookie("path1","path1");
        //req.getContextPath()得到工程路径
        cookie.setPath(req.getContextPath()+"/abc");
        resp.addCookie(cookie);
        resp.getWriter().write("创建了一个带有path路径的Cookie");
    }
}
