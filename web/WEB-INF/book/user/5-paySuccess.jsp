<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>支付成功的页面</title>
</head>
<body>

<div>
    您的订单已经生存，订单编号为 ${orderId}，请您随时关注订单的状态。
</div>

<c:remove var="orderId" scope="session" />

</body>
</html>
