package com.atguigu.web;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author fxStart
 * @create 2022-10-11-23:32
 */
public class ClientBookServlet extends BaseServlet{
    private BookService bookService=new BookServiceImpl();
    /**
     * 处理分页功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("经过了前台的ClientBookServlet程序");
        int pageNo= WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize=WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //根据pageNo和pageSize，得到对应的page对象
        Page<Book> page = bookService.page(pageNo, pageSize);
        page.setUrl("client/bookServlet?action=page");
        //保存page对象到request域中
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }

    /**
     * 处理按价格查询功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int min = WebUtils.parseInt(req.getParameter("min"), 0);
        int max = WebUtils.parseInt(req.getParameter("max"), Integer.MAX_VALUE);
        int pageNo= WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize=WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        Page<Book> page = bookService.pageByPrice(pageNo, pageSize, min, max);
        StringBuilder sb=new StringBuilder("client/bookServlet?action=pageByPrice");
        //如果有最小价格参数。追加到分页条的参数中
//        if(req.getParameter("min")!=null){
//            sb.append("&min=").append(req.getParameter("min"));
//        }
//        if(req.getParameter("max")!=null){
//            sb.append("&max=").append(req.getParameter("max"));
//        }
        page.setUrl(sb.toString());
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }
}
