<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022/9/29
  Time: 23:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>pageContext</title>
</head>
<body>
    <%=request.getScheme()%> <br>
    1. 协议：${pageContext.request.scheme} <br><br>

    <%=request.getServerName()%> <br>
    2. 服务器 ip：${pageContext.request.serverName}<br><br>

    <%=request.getServerPort()%> <br>
    3. 服务器端口：${pageContext.request.serverPort} <br><br>

    <%=request.getContextPath()%> <br>
    4. 获取工程路径：${pageContext.request.contextPath}<br><br>

    <%=request.getMethod()%> <br>
    5. 获取请求方法：${pageContext.request.method}<br><br>

    <%=request.getRemoteHost()%> <br>
    6. 获取客户端 ip 地址：${pageContext.request.remoteHost} <br><br>

    <%=session.getId()%> <br>
    7. 获取会话的 id 编号：${pageContext.session.id}<br><br>

</body>
</html>
