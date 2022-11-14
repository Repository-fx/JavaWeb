package com.atguigu.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author fxStart
 * @create 2022-10-24-11:25
 */
public class AdminFilter implements Filter {
    public AdminFilter() {
        System.out.println("1.Filter构造器方法AdminFilter");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("2.Filter的init初始化");
        //获取Filter的名称
        System.out.println("filter-name的值是："+filterConfig.getFilterName());
        //获取在web.xml中配置的init-param
        System.out.println("初始化参数username的值是："+filterConfig.getInitParameter("username"));
        System.out.println("初始化参数url的值是："+filterConfig.getInitParameter("url"));
        //获取ServletContext对象
        System.out.println(filterConfig.getServletContext());
    }

    /**
     * 专门用于拦截请求，可以做权限检查
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter过滤器的doFilter方法");
        HttpServletRequest httpServletRequest=(HttpServletRequest)servletRequest;
        HttpSession session=httpServletRequest.getSession();

        Object user = session.getAttribute("user");
        if(user==null){
            httpServletRequest.getRequestDispatcher("/login.jsp").forward(servletRequest,servletResponse);
            return ;
        }else{
            //让程序继续往下访问用户的目标资源（放行）
            filterChain.doFilter(servletRequest,servletResponse);
        }

    }

    @Override
    public void destroy() {
        System.out.println("Filter过滤器的destroy方法");
    }
}
