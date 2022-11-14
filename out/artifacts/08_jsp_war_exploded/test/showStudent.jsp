<%@ page import="com.atguigu.pojo.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022/9/29
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test2</title>
    <style>
        table{
            border: 1px black solid;
            width: 600px;
            border-collapse: collapse;
        }
        td,th{
            border: 1px black solid;
        }
    </style>
</head>
<body>
<%--练习二：jsp输出一个表格，里面有10个学生信息--%>
    <%
        List<Student> studentList= (List<Student>) request.getAttribute("stuList");
//        for (int i=0;i<10;i++){
//            int t=i+1;
//            studentList.add(new Student(t,"name"+t,18+t,"phone"+t));
//        }
    %>
    <h1 align="center">学生信息表</h1>
    <table align="center">
        <tr>
            <th>id</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>电话</th>
            <th>操作</th>
        </tr>
        <% for(Student stu:studentList){ %>

        <tr>
            <td>
                <%= stu.getId()%>
            </td>
            <td >
                <%= stu.getName()%>
            </td>
            <td >
                <%= stu.getAge()%>
            </td>
            <td >
                <%= stu.getPhone()%>
            </td>
            <td>删除、修改</td>
        </tr>
        <% } %>
    </table>


</body>
</html>
