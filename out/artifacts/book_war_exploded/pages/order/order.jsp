<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的订单</title>
	<%--静态包含base标签，css样式，jQuery文件--%>
	<%@include file="/pages/common/head.jsp"%>>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">我的订单</span>
		<%--			静态包含登录成功后的菜单--%>
		<%@include file="/pages/common/login_success_menu.jsp"%>>
	</div>
	
	<div id="main">
		<table>
			<c:if test="${empty sessionScope.myOrders}">
				<tr>
					<td colspan="4">当前没有订单！</td>
				</tr>
			</c:if>

			<c:if test="${not empty sessionScope.myOrders}">
				<tr>
					<td colspan="2">日期</td>
					<td>金额</td>
					<td>状态</td>
					<td>详情</td>
				</tr>
				<c:forEach items="${sessionScope.myOrders}" var="order">
					<tr>
						<td colspan="2">${order.createTime.toLocalDate()}-${order.createTime.toLocalTime()}</td>
						<td>${order.price}</td>
						<c:if test="${order.status==0}">
							<td><a href="orderServlet?action=sendOrder&orderId=${order.orderId}">点击发货</a></td>
						</c:if>
						<c:if test="${order.status==1}">
							<td>已发货</td>
						</c:if>
						<c:if test="${order.status==2}">
							<td>已签收</td>
						</c:if>
						<td><a href="orderServlet?action=showOrderDetail&orderId=${order.orderId}">查看详情</a></td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
	</div>

	<%@include file="/pages/common/footer.jsp"%>
</body>
</html>