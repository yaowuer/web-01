<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div>
    <c:if test="${empty cart}">
        抱歉，您的购物车目前是空的哦，请返回首页进行选择！
    </c:if>

    <table class="tb">
        <caption style="font-weight: bold; margin-bottom: 20px;">我的购物车</caption>
        <tr>
            <th>序号</th>
            <th>书名</th>
            <th>单价</th>
            <th>数量</th>
            <th>操作</th>
        </tr>

        <c:forEach var="item" varStatus="s" items="${cart.all}">
            <tr>
                <td>${s.count}</td>
                <td>${item.book.name}</td>
                <td>${item.book.price}</td>
                <td>${item.count}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/book/delFromCart?id=${item.book.id}">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <div class="summary">
        <p>
            <a href="#">进行结算</a>
            <a href="#">清空购物车</a>
        </p>
        <p>当前总共购买 ${cart.count} 件商品，总价 ${cart.totalPrice} 元，请点击</p>
    </div>
</div>

