<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022/10/24
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp</title>
</head>
<body>
            <%
                System.out.println("a.jsp页面执行了");
                Object user=session.getAttribute("user");
                //如果等于null，说明没有登录
                if(user==null){
                    request.getRequestDispatcher("/login.jsp").forward(request,response);
                    return ;
                }
            %>
我是a.jsp
</body>
</html>
