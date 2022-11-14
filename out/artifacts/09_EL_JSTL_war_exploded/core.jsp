<%@ page import="com.atguigu.pojo.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022/9/30
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>core</title>
</head>
<body>
    保存之前${pageScope.abc} <br>
    <c:set scope="page" var="abc" value="abcValue"/>
    保存之后${pageScope.abc} <br>
    <hr>
    <%
        List<Student> studentList=new ArrayList<>();
        for(int i=0;i<10;i++){
            studentList.add(new Student(i,"username"+i,"pass"+i,18+i,"phone"+i));
        }
        request.setAttribute("stus",studentList);
    %>
<c:forEach items="${requestScope.stus}" var="stu">
    ${stu}<br>
</c:forEach>
</body>
</html>
