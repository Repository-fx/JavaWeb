<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022/9/30
  Time: 12:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>other</title>
</head>
<body>
    输出请求参数username的值： ${param.username}<br>
    输出请求参数password的值： ${param.password}<br>

    ${paramValues.hobby}<br>
    <hr>

    输出请求头User-Agent的值：${header["User-Agent"]}<br>
    输出请求头User-Agent的值：${headerValues['User-Agent'][0]}<br>
    <hr>

    ${cookie} <br>
    ${cookie['Idea-43d88c3f']}<br>
    获取Cookie的名称：${cookie.JSESSIONID.name} <br>
    获取Cookie的值  ${cookie.JSESSIONID.value}<br>
    <hr>

    输出&lt;Context-param&gt;${initParam.username}<br>
    输出&lt;Context-param&gt;${initParam.url}<br>

</body>
</html>
