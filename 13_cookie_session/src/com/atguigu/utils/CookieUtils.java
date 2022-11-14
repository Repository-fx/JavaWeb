package com.atguigu.utils;

import javax.servlet.http.Cookie;

/**
 * @author fxStart
 * @create 2022-10-14-14:47
 */
public class CookieUtils {
    /**
     * 查找指定名称的Cookie对象
     * @param name
     * @param cookies
     * @return
     */
    public static Cookie findCookie(String name,Cookie[] cookies){
        if(name==null || cookies==null || cookies.length==0){
            return null;
        }
        for(Cookie cookie:cookies){
            if(name.equals(cookie.getName())){
                return cookie;
            }
        }
        return null;
    }
}
