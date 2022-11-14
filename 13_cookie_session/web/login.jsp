<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022/10/14
  Time: 22:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <base href="http://localhost:8080/13_cookie_session/">
</head>
<body>
    <form action="loginServlet" method="get">
        用户名：<input type="text" name="username" value="${cookie.username.value}"><br/>
        密 码 ：<input type="password" name="password" id=""><br/>
        <input type="submit" value="登录">
    </form>
</body>
</html>
