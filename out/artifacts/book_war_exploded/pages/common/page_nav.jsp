<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022/10/12
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--分页条的开始--%>
<div id="page_nav">
    <%--			大于首页才显示--%>
    <c:if test="${requestScope.page.pageNo>1}">
        <a href="${requestScope.page.url}&pageNo=1">首页</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo-1}">上一页</a>
        <%--				<a href="manager/bookServlet?action=page&pageNo=${requestScope.page.pageNo-1}">${requestScope.page.pageNo-1}</a>--%>
    </c:if>
    <%--	页码输出的开始--%>
    <c:choose>
        <%--		情况一：如果总页码小于等于5的情况，页码范围是1-总页码 --%>
        <c:when test="${requestScope.page.pageTotal<=5}">
            <c:set var="begin" value="1"/>
            <c:set var="end" value="${requestScope.page.pageTotal}"/>
        </c:when>
        <%--		情况二：如果总页码大于5的情况，页码范围是总页码-4 - 总页码--%>
        <c:when test="${requestScope.page.pageTotal>5}">
            <c:choose>
                <%--						小情况1：当前页码为前面3个：1、2、3的情况，页码范围是1-5 --%>
                <c:when test="${requestScope.page.pageNo<=3}">
                    <c:set var="begin" value="1"/>
                    <c:set var="end" value="5"/>
                </c:when>
                <%--						小情况2：当前页码为后面3个--%>
                <c:when test="${requestScope.page.pageNo>=requestScope.page.pageTotal-2}">
                    <c:set var="begin" value="${requestScope.page.pageTotal-4}"/>
                    <c:set var="end" value="${requestScope.page.pageTotal}"/>
                </c:when>
                <c:otherwise>
                    <c:set var="begin" value="${requestScope.page.pageNo-2}"/>
                    <c:set var="end" value="${requestScope.page.pageNo+2}"/>
                </c:otherwise>
            </c:choose>

            <c:forEach begin="${begin}" end="${end}" var="i">
                <c:if test="${i==requestScope.page.pageNo}">
                    【${i}】
                </c:if>
                <c:if test="${i!=requestScope.page.pageNo}">
                    <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
                </c:if>
            </c:forEach>

        </c:when>
    </c:choose>
    <%--	页码输出的结束--%>
    <%--			【${requestScope.page.pageNo}】--%>
    <c:if test="${requestScope.page.pageNo<requestScope.page.pageTotal}">
        <%--				<a href="manager/bookServlet?action=page&pageNo=${requestScope.page.pageNo+1}">${requestScope.page.pageNo+1}</a>--%>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo+1}">下一页</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageTotal}">末页</a>
    </c:if>

    共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录
    到第<input value="${param.pageNo}" name="pn" id="pn_input"/>页
    <input id="searchPageBtn" type="button" value="确定">
</div>
<%--分页条的结束--%>
