package com.atguigu.dao;

import com.atguigu.pojo.User;

/**
 * @author fxStart
 * @create 2022-09-26-22:58
 */
public interface UserDao {
    /**
     * 根据用户名查询用户信息
     * @param username
     * @return 如果返回null，说明没有这个用户，反之亦然
     */
    public User queryUserByUsername(String username);

    /**
     * 保存用户信息
     * @param user
     * @return 返回-1表示操作失败
     */
    public int saveUser(User user);

    /**
     * 查询用户根据用户名和密码
     * @param username
     * @param password
     * @return 如果返回null，说明用户名或密码错误
     */
    public User queryUserByUsernameAndPassword(String username,String password);
}
