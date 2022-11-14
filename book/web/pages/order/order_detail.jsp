<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>订单详情</title>
    <%--静态包含base标签，css样式，jQuery文件--%>
    <%@include file="/pages/common/head.jsp"%>
</head>

<body>
    <div id="header">
        <img class="logo_img" alt="" src="static/img/logo.gif" >
        <span class="wel_word">订单详情</span>
        <%--			静态包含登录成功后的菜单--%>
        <%@include file="/pages/common/login_success_menu.jsp"%>>
    </div>

    <div id="main">
        <%--订单不存在--%>
        <c:if test="${empty sessionScope.orderItems}">
            <table>
                <tr>
                    <td>商品名称</td>
                    <td>数量</td>
                    <td>单价</td>
                    <td>总价</td>
                    <td>操作</td>
                </tr>
                <tr>
                    <th colspan="5"><a href="index.jsp">亲, 该订单不存在!</a></th>
                </tr>
            </table>
        </c:if>

        <%--订单存在--%>
        <c:if test="${not empty sessionScope.orderItems}">
            <table>
                <tr>
                    <td>商品名称</td>
                    <td>数量</td>
                    <td>单价</td>
                    <td>总价</td>
                </tr>
                <c:forEach var="item" items="${sessionScope.orderItems}">
                    <tr>
                        <td>${item.name}</td>
                        <td>${item.count}</td>
                        <td>${item.price}</td>
                        <td>${item.totalPrice}</td>
                    </tr>
                </c:forEach>
            </table>

            <div class="cart_info">
                <span class="order_span">总金额<span class="b_price">${sessionScope.order.price}</span>元</span><br/>
                <span class="order_span">订单编号<span class="b_price">${sessionScope.order.orderId}</span></span><br/>
                <span class="order_span">创建时间<span class="b_price">${sessionScope.order.createTime}</span></span><br/>
                <span class="order_span">订单状态<span class="b_price">
                <c:if test="${sessionScope.order.status==0}">
                    <span>未发货</span>
                </c:if>
                <c:if test="${sessionScope.order.status==1}">
                    <span>已发货</span>
                    <span class="order_span"><a
                            href="orderServlet?action=receiveOrder&orderId=${sessionScope.order.orderId}">确认收货
                    </a></span>
                </c:if>
                <c:if test="${sessionScope.order.status==2}">
                    <span>已收货</span>
                </c:if>
            </span></span><br/>
            </div>
        </c:if>
    </div>

</body>
</html>
