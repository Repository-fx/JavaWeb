package com.atguigu.test;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author fxStart
 * @create 2022-10-04-10:18
 */
public class BookServiceTest {
    private BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book(null, "为什么是中国", "金一南", new BigDecimal(99.9), 34578, 0, null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(45);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(43, "为什么是中国", "金一南", new BigDecimal(69.9), 34578, 0, null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(43));
    }

    @Test
    public void queryBooks() {
        for (Book book : bookService.queryBooks()) {
            System.out.println(book);
        }
    }

    @Test
    public void page(){
        Page<Book> page = bookService.page(1, 4);
        System.out.println(page);
    }

    @Test
    public void pageByPrice(){
        Page<Book> page = bookService.pageByPrice(1, 4, 50, 100);
        System.out.println(page);
    }
}