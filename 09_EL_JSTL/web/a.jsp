<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022/9/29
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>a.jsp</title>
</head>
<body>
    <%
        request.setAttribute("key","值");
    %>
    表达式脚本输出key的值是：<%=request.getAttribute("key1")%> <br>

    EL表达式输出key的值是： ${key1}
</body>
</html>
