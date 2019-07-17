<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的购物车</title>
</head>
<body>

<ul>
    <c:if test="${empty cart}">
        抱歉，您的购物车目前是空的哦，请返回首页选择您信息。胜多负少的
    </c:if>

    <c:forEach var="item" items="${cart.all}">
        <li>书名: ${item.book.name};  单价: ${item.book.price};  购买数量: ${item.count}</a></li>
    </c:forEach>
</ul>

</body>
</html>
