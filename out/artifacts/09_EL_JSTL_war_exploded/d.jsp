<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022/9/29
  Time: 22:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>d.jsp</title>
</head>
<body>
    <%
        Map<String,Object> map=new HashMap<>();
        map.put("aaa","aaaValue");
        map.put("b+b+b","bbbValue");
        map.put("c-c-c","cccValue");

        request.setAttribute("map",map);
    %>

    ${map['aaa']}
</body>
</html>
