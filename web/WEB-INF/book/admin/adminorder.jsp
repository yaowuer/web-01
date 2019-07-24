<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}" scope="page"/>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${root}/assets/common.css">
</head>
<body>
<div>
    <table id="tb1">
        <tr>
            <th>订单编号</th>
            <th>用户账号</th>
            <th>收货人</th>
            <th>收货电话</th>
            <th>收货地址</th>
            <th>状态</th>
            <th>订单详情</th>
            <th>操作</th>

        </tr>
        <c:forEach var="order" items="${orderk}">
            <c:if test="${order.status =='已支付'}">
                <tr>
                    <td>${order.id}</td>
                    <td>${order.account.username}</td>
                    <td>${order.receiver}</td>
                    <td>${order.phone}</td>
                    <td>${order.addr}</td>
                    <td>${order.status}</td>
                    <td><a href="dingdanxiangqing?id=${order.id}">查看</a></td>
                    <td><a href="fahuo?id=${order.id}">发货</a></td>
                </tr>
            </c:if>
        </c:forEach>
    </table>
</div>

</body>
</html>
