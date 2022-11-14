package com.atguigu.web;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.WebUtils;
import com.google.gson.Gson;
import com.sun.xml.internal.bind.v2.model.core.ID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fxStart
 * @create 2022-10-18-20:25
 */
public class CartServlet extends BaseServlet{
    private BookService bookService=new BookServiceImpl();
    /**
     * 加入购物车
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数，商品编号
        int id= WebUtils.parseInt(req.getParameter("id"),0);
        Book book = bookService.queryBookById(id);
        CartItem cartItem=new CartItem(book.getId(),book.getName(),1,book.getPrice(),book.getPrice());
        Cart cart= (Cart) req.getSession().getAttribute("cart");
        if (cart==null){
            cart=new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        cart.addItem(cartItem);
//        System.out.println(cart);
        //重定向回商品列表页面
        //重定向回原来商品所在的页面
        resp.sendRedirect(req.getHeader("Referer"));
        //最后一个添加的商品名称
        req.getSession().setAttribute("lastName",cartItem.getName());
    }
    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart= (Cart) req.getSession().getAttribute("cart");
        int id = WebUtils.parseInt(req.getParameter("id"), 0);

        if (cart!=null) {
            cart.deleteItem(id);
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if(cart!=null){
            cart.clear();
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }
    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数，商品编号和商品数量
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        int count = WebUtils.parseInt(req.getParameter("count"), 1);

        //获取cart购物车对象
        Cart cart =(Cart) req.getSession().getAttribute("cart");
        if(cart!=null){
            //修改商品数量
            cart.updateCount(id,count);
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }
    protected void ajaxAddItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数，商品编号
        int bookId= WebUtils.parseInt(req.getParameter("bookId"),0);
        Book book = bookService.queryBookById(bookId);
        CartItem cartItem=new CartItem(book.getId(),book.getName(),1,book.getPrice(),book.getPrice());
        Cart cart= (Cart) req.getSession().getAttribute("cart");
        if (cart==null){
            cart=new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        cart.addItem(cartItem);

        req.getSession().setAttribute("lastName",cartItem.getName());
        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("totalCount",cart.getTotalCount());
        resultMap.put("lastName",cartItem.getName());

        Gson gson=new Gson();
        String resultMapJsonString = gson.toJson(resultMap);
        resp.getWriter().write(resultMapJsonString);
    }
}
