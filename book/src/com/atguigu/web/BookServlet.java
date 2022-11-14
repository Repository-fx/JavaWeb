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
import java.math.BigDecimal;
import java.util.List;

/**
 * @author fxStart
 * @create 2022-10-04-11:12
 */
public class BookServlet extends BaseServlet{
    private BookService bookService=new BookServiceImpl();

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo=WebUtils.parseInt(req.getParameter("pageNo"),1);
        pageNo++;
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        bookService.addBook(book);
        //请求转发不能用，地址栏不变会有重复提交的风险
//        req.getRequestDispatcher("/manager/bookServlet?action=list").forward(req,resp);
        //请求重定向
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page&pageNo="+pageNo);
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=WebUtils.parseInt(req.getParameter("id"),-1);
        bookService.deleteBookById(id);
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page&pageNo="+req.getParameter("pageNo"));
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        bookService.updateBook(book);
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page&pageNo="+req.getParameter("pageNo"));
    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、通过BookService查询全部图书
        List<Book> books = bookService.queryBooks();
        //2、把全部图书保存到Request域中
        req.setAttribute("books",books);
        //3、请求转发到pages/manager/book_manager.jsp
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }

    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=WebUtils.parseInt(req.getParameter("id"),-1);
        Book book = bookService.queryBookById(id);
        req.setAttribute("book",book);
        //请求转发
        req.getRequestDispatcher("/pages/manager/book_edit.jsp?pageNo="+req.getParameter("pageNo")).forward(req,resp);
//        resp.sendRedirect(req.getContextPath()+"/pages/manager/book_edit.jsp");
    }

    /**
     * 处理分页功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo=WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize=WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //根据pageNo和pageSize，得到对应的page对象
        Page<Book> page = bookService.page(pageNo, pageSize);
        page.setUrl("manager/bookServlet?action=page");
        //保存page对象到request域中
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }
}
