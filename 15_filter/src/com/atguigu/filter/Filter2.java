package com.atguigu.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author fxStart
 * @create 2022-10-24-16:23
 */
public class Filter2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter2前置代码");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("Filter2后置代码");
    }

    @Override
    public void destroy() {

    }
}
