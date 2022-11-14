package com.atguigu.test;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author fxStart
 * @create 2022-10-03-23:03
 */
public class BookDaoTest {
    private BookDao bookDao=new BookDaoImpl();

    @Test
    public void addBook() {
        bookDao.addBook(new Book(null,"为什么是中国","金一南",new BigDecimal(99.9),110000,0,null));
    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(42);
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(42,"为什么是中国","金一南",new BigDecimal(69.9),110000,0,null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(42));
    }

    @Test
    public void queryBooks() {
        for (Book queryBook:bookDao.queryBooks()){
            System.out.println(queryBook);
        }
    }

    @Test
    public void queryForPageTotalCount(){
        System.out.println(bookDao.queryForPageTotalCount());
    }

    @Test
    public void queryForPageItems(){
        List<Book> books = bookDao.queryForPageItems(0, 4);
        for (Book book:books){
            System.out.println(book);
        }
    }

    @Test
    public void queryForPageTotalCountByPrice(){
        Integer count = bookDao.queryForPageTotalCountByPrice(50, 100);
        System.out.println(count);
    }
    @Test
    public void queryForPageItemsByPrice(){
        List<Book> books = bookDao.queryForPageItemsByPrice(1, Page.PAGE_SIZE,50,100);
        for (Book book:books){
            System.out.println(book);
        }
    }
}