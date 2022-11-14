package com.atguigu.test;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author fxStart
 * @create 2022-09-27-9:49
 */
public class UserServiceImplTest {
    UserService userService=new UserServiceImpl();
    @Test
    public void registUser() {
        userService.registUser(new User(null,"bbj168","666666","bbj168@qq.com"));
        userService.registUser(new User(null,"abc168","666666","abc168@qq.com"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null,"fxxxx","123456","fxxx@qq.com")));
    }

    @Test
    public void existsUsername() {
        if (userService.existsUsername("fxxwefxx")){
            System.out.println("用户名已存在");
        }else{
            System.out.println("用户名不存在，可用");
        }
    }
}