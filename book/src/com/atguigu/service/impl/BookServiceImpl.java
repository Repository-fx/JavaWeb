package com.atguigu.service.impl;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;

import java.util.List;

/**
 * @author fxStart
 * @create 2022-10-04-10:05
 */
public class BookServiceImpl implements BookService {
    private BookDao bookDao=new BookDaoImpl();
    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {

        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page=new Page<>();

        //设置每页显示的数量
        page.setPageSize(pageSize);
        //设置总的记录数
        Integer pageTotalCount=bookDao.queryForPageTotalCount();
        page.setPageTotalCount(pageTotalCount);
        //设置总的页码
//        Integer pageTotal=(int)Math.ceil(pageTotalCount/pageSize);
        Integer pageTotal=pageTotalCount/pageSize;
        if (pageTotalCount%pageSize>0){
            pageTotal++;
        }
        page.setPageTotal(pageTotal);

        //设置当前页码
        page.setPageNo(pageNo);

        //设置当前页数据
        int begin=(pageNo-1)*pageSize; //当前页数据的开始索引
        List<Book> items = bookDao.queryForPageItems(begin, pageSize);
        page.setItems(items);
        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Book> page=new Page<>();
        page.setPageSize(pageSize);
        //总记录数
        Integer pageTotalCount = bookDao.queryForPageTotalCountByPrice(min, max);
        page.setPageTotalCount(pageTotalCount);
        //总页码
        int pageTotal=pageTotalCount/pageSize;
        if (pageTotalCount%pageSize>0){
            pageTotal++;
        }
        page.setPageTotal(pageTotal);
        page.setPageNo(pageNo);
        int begin=(pageNo-1)*pageSize;
        List<Book> items = bookDao.queryForPageItemsByPrice(begin, pageSize,min,max);
        page.setItems(items);
        return page;
    }
}
