package com.atguigu.utils;

import com.atguigu.pojo.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author fxStart
 * @create 2022-10-02-22:44
 */
public class WebUtils {
    public static <T>T copyParamToBean(Map value, T bean){
        try {
//            System.out.println("注入之前："+bean);
            //把所有请求参数都注入到user对象中
            BeanUtils.populate(bean,value);
//            System.out.println("注入之后："+bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
    public static int parseInt(String strInt,int defaultNum){
        try {
            return Integer.parseInt(strInt);
        } catch (NumberFormatException e) {
//            e.printStackTrace();
        }
        return defaultNum;
    }
}
