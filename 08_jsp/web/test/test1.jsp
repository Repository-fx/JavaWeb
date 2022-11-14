<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022/9/29
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test1</title>
    <style>
        table{
            width: 650px;
        }
    </style>
</head>
<body>
<%--    练习1：输出九九乘法表 --%>
<h1 align="center">九九乘法表</h1>
<table align="center">
    <% for (int i=1;i<=9;i++){ %>
    <tr>
        <% for(int j=1;j<=i;j++){ %>
        <td>
            <%= i+"x"+j+"="+(i*j)%>
            <% } %><br/>
        </td>

        <% } %>
    </tr>
</table>
</body>
</html>
