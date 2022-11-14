package com.atguigu.servlet;

import com.atguigu.pojo.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author fxStart
 * @create 2022-09-29-14:19
 */
public class SearchStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数
        //发SQL语句查询学生信息
        ArrayList<Student> studentList = new ArrayList<>();
        for(int i=0;i<10;i++){
            int t=i+1;
            studentList.add(new Student(t,"name"+t,18+t,"phone"+t));
        }
        //保存查询到的结果到request域中
        req.setAttribute("stuList",studentList);
        //请求转发到ShowStudent.jsp页面
        req.getRequestDispatcher("/test/showStudent.jsp").forward(req,resp);
    }
}
