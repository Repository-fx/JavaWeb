<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022/10/24
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
</head>
<body>
这是登录界面<br>

<form action="http://localhost:8080/15_filter/loginServlet" method="get">
    用户名：<input type="text" name="username"/> <br>
    密码 ：<input type="password" name="password"/> <br>
    <input type="submit" />
</form>
</body>
</html>
