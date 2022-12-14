package com.atguigu.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author fxStart
 * @create 2022-10-24-18:48
 */
public class ManagerFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        Object user = httpServletRequest.getSession().getAttribute("user");
        if(user==null){ //说明没登录
            httpServletRequest.getRequestDispatcher("/pages/user/login.jsp").forward(servletRequest,servletResponse);
        }else{ //已经登录
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
