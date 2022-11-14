<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
	<%--静态包含base标签，css样式，jQuery文件--%>
	<%@include file="/pages/common/head.jsp"%>
</head>
<body>
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>
		<%--			静态包含登录成功后的菜单--%>
		<%@include file="/pages/common/login_success_menu.jsp"%>>
		<script type="text/javascript">
			$(function () {
				$("a.deleteItem").click(function () {
					return confirm("你确定要删除【"+$(this).parent().parent().find("td:first").text()+"】吗？");
				});
				$("a.clearCart").click(function () {
					return confirm("你确定要清空购物车吗？");
				});
				//给输入框绑定失去焦点事件 blur
				//给输入框绑定内容改变事件 onChange
				$(".updateCount").change(function () {
					//获取商品名称
					var name = $(this).parent().parent().find("td:first").text();
					//获取商品数量
					var count = this.value;
					//获取编号
					var bookId = $(this).attr("bookId");
					if(confirm("你确定要将【"+name+"】商品数量修改为"+count)){
						//发起请求，给服务器保存修改
						location.href="${basePath}cartServlet?action=updateCount&count="+count+"&id="+bookId;
						return true;
					}else{//取消
						//defaultValue是表单项dom对象的属性，表示的默认的value属性值
						this.value=this.defaultValue;
					}
				});
			});
		</script>
	</div>
	
	<div id="main">
	
		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>
			<c:if test="${empty sessionScope.cart.items}">
<%--				如果购物车为空--%>
				<tr>
					<td colspan="5"><a href="index.jsp">当前购物车为空！去首页浏览吧！</a></td>
				</tr>
			</c:if>
			<c:if test="${not empty sessionScope.cart.items}">
<%--				如果购物车非空--%>
				<c:forEach items="${sessionScope.cart.items}" var="entry">
					<tr>
						<td>${entry.value.name}</td>
						<td>
							<input class="updateCount" style="width: 60px"
								   bookId="${entry.value.id}"
								   type="text" value="${entry.value.count}"/>
						</td>
						<td>${entry.value.price}</td>
						<td>${entry.value.totalPrice}</td>
						<td><a class="deleteItem" href="cartServlet?action=deleteItem&id=${entry.key}">删除</a></td>
					</tr>
				</c:forEach>
			</c:if>

		</table>
		<c:if test="${not empty sessionScope.cart.items}">
			<div class="cart_info">
				<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
				<span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
				<span class="cart_span"><a class="clearCart" href="cartServlet?action=clear">清空购物车</a></span>
				<span class="cart_span"><a href="orderServlet?action=createOrder">去结账</a></span>
			</div>
		</c:if>
	</div>

	<%@include file="/pages/common/footer.jsp"%>
</body>
</html>