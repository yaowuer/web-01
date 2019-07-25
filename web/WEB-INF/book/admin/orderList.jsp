<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}" scope="page"/>
<html>
<head>
    <title>订单管理</title>
    <link rel="stylesheet" href="${root}/assets/common.css">
    <style>
        .tb {
            width: 90%;
        }

        .main {
            display: flex;
            flex-flow: nowrap row;
            width: 100%;
        }

        .main > aside {
            flex: 0 0 150px;
        }

        .main > section {
            flex: 1;
        }
    </style>
</head>
<body>

<header>
    <h1>书籍管理系统 <span style="font-size: 12px">欢迎您，管理员</span></h1>
</header>
<div class="main">
    <aside>
        <ul>
            <li>
                <a href="${root}/book/admin/manage">书籍管理</a>
            </li>
            <li>作者管理</li>
            <li>出版社管理</li>
            <li>
                <a href="${root}/book/admin/orderManger">订单管理</a>
            </li>
            <li>用户管理</li>
            <li>系统设置</li>
        </ul>
    </aside>
    <section>
        <div class="orders">
            <c:forEach items="${orders}" var="order" varStatus="s">
                <section class="order">
                    <p>
                        订单 ${s.count} - 接收人: ${order.receiver} 电话: ${order.phone} 地址: ${order.addr} 状态: ${order.status}
                        <c:if test="${order.status == '已支付'}">
                            <a href="${pageContext.request.contextPath}/book/user/delivered?id=${order.id}">确认发货</a>
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

    </section>
</div>

</body>
</html>
