<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单详情</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/common.css">
</head>
<body>

<div class="orders">
    <c:forEach items="${orders}" var="order" varStatus="s">
        <section class="order">
            <p>
                订单 ${s.count} - 接收人: ${order.receiver} 电话: ${order.phone} 地址: ${order.addr} 状态: ${order.status}
                <c:if test="${order.status == '已发货'}">
                    <a href="${pageContext.request.contextPath}/book/user/doCheck?id=${order.id}">确认收货</a>
                </c:if>
            </p>
            <table>
                <c:forEach items="${order.orderDetail}" var="detail" varStatus="ds">
                    <tr>
                        <td>${detail.key.name}</td>
                        <td>${detail.key.price}</td>
                        <td>${detail.key.author}</td>
                        <td>${detail.value}</td>
                    </tr>
                </c:forEach>
            </table>
        </section>
    </c:forEach>
</div>


</body>
</html>
