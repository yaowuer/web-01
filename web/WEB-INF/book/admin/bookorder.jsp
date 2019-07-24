<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}" scope="page"/>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${root}/assets/common.css">
</head>
<body>
<c:if test="${orderrr !=null}">
    <div style="display: block" id="div2">
        <table>
            <tr>
                <th>图书名称</th>
                <th>图书价格</th>
                <th>图书作者</th>
                <th>图书数量</th>
            </tr>
            <c:forEach items="${orderrr}" var="order" >
                <c:forEach items="${order.orderDetail}" var="detail">
                    <tr>
                        <td>${detail.key.name}</td>
                        <td>${detail.key.price}</td>
                        <td>${detail.key.author}</td>
                        <td>${detail.value}</td>
                    </tr>
                </c:forEach>
            </c:forEach>
        </table>
    </div>
</c:if>
</body>
</html>
