<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022/10/2
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
//    request.getSchema()可以返回当前页面使用的协议，http 或是 https;
//    request.getServerName()可以返回当前页面所在的服务器的名字;
//    request.getServerPort()可以返回当前页面所在的服务器使用的端口,就是80;
//    request.getContextPath()可以返回当前页面所在的应用的名字;
    String basepath=request.getScheme()
                    +"://"
                    +request.getServerName()
                    +":"
                    +request.getServerPort()
                    +request.getContextPath()
                    +"/";
    pageContext.setAttribute("basePath",basepath);
%>
<!--写base标签，永远固定相对路径跳转的结果-->
<base href="<%=basepath%>">
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
