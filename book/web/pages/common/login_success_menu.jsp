<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022/10/2
  Time: 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div>
    <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临尚硅谷书城</span>
    <a href="orderServlet?action=showMyOrders">我的订单</a>
    <a href="userServlet?action=loginOut">注销</a>
    <a href="javaScript:history.back()">返回</a>
<%--    <a href="index.jsp">首页</a>--%>
</div>