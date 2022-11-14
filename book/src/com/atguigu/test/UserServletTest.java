package com.atguigu.test;

import java.lang.reflect.Method;

/**
 * @author fxStart
 * @create 2022-10-02-17:23
 */
public class UserServletTest {
    public static void main(String[] args) {
        String action="regist";
        try {
            //获取action业务鉴别字符串，获取相应的业务 方法反射对象
            Method method = UserServletTest.class.getDeclaredMethod(action);
            System.out.println(method);
            //调用目标业务方法
            method.invoke(new UserServletTest());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void login(){
        System.out.println("这是login方法");
    }
    public void regist(){
        System.out.println("这是regist方法");
    }
    public void updateUser(){
        System.out.println("这是updateUser被调用了");
    }
    public void updateUserPassword(){
        System.out.println("这是updateUserPassword被调用了");
    }
}
