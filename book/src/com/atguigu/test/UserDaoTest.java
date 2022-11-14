package com.atguigu.test;

import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author fxStart
 * @create 2022-09-26-23:39
 */
public class UserDaoTest {
    UserDao userDao=new UserDaoImpl();
    @Test
    public void queryUserByUsername() {

        System.out.println(userDao.queryUserByUsername("admin"));
        if (userDao.queryUserByUsername("admin")==null){
            System.out.println("用户名可用！");
        }else{
            System.out.println("用户名已存在！");
        }
    }

    @Test
    public void saveUser() {
        System.out.println(userDao.saveUser(new User(null,"fxxxx","123456","fxxx@qq.com")));
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        if (userDao.queryUserByUsernameAndPassword("admin", "admin")==null){
            System.out.println("用户名或密码错误，登录失败！");
        }else{
            System.out.println("登录成功！");
        }
    }
}