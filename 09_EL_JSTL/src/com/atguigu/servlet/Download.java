package com.atguigu.servlet;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

/**
 * @author fxStart
 * @create 2022-10-01-14:44
 */
public class Download extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取要下载的文件名
        String downloadFileName="0.jpg";
        //2、读取要下载的文件内容（通过ServletContext对象可以读取）
        ServletContext servletContext = getServletContext();
        //4、回传前，通过响应头告诉客户端返回的数据类型
        //获取要下载的文件类型
        String mimeType = servletContext.getMimeType("/file/" + downloadFileName);
        System.out.println("下载的文件类型:"+mimeType);
        resp.setContentType(mimeType);
        //5、还要告诉客户端收到的数据是用于下载使用（还是使用响应头）
        //attachment表示附件，表示下载使用
        //filename=表示指定下载的文件名
        //url编码是把汉字转化成%xx%xx的格式
//        resp.setHeader("Content-Disposition","attachment;filename="+downloadFileName);
//        resp.setHeader("Content-Disposition","attachment;filename=图片.jpg");
        resp.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode("图片","UTF-8"));

        //输入流
        InputStream resourceAsStream = servletContext.getResourceAsStream("/file/" + downloadFileName);
        //获取响应的输出流
        ServletOutputStream outputStream = resp.getOutputStream();
        //读取输入流中全部的数据，复制给输出流，输出给客户端
        IOUtils.copy(resourceAsStream,outputStream);
        //3、把下载的文件内容回传给客户端

    }
}
