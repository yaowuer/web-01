<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我看到的货架</title>
    <style>
        img {
            height: 100px;
        }
        .main {
            width: 900px;
            margin: auto;
            padding: 50px;
            display: flex;
        }
        .goods {
            border: 1px solid gray;
            padding: 10px;
            margin: 10px;

        }
    </style>
</head>
<body>

<c:set var="root" value="${pageContext.request.contextPath}" scope="page" />

<header>
    <div style="text-align: right">
        <a href="${root}/book/listCart">查看购物车</a>
        <a href="${root}/book/check">进行结算</a>
    </div>
</header>

<div class="main">
    <c:forEach var="book" items="${books}">
        <section class="goods">
            <header>${book.name}</header>
            <p><img src="${root}/assets/apple.jpg"></p>
            <footer>
                <span>￥${book.price}元</span>
                <a href="${root}/book/addCart?id=${book.id}">加入购物车</a>
            </footer>
        </section>
    </c:forEach>
</div>

</body>
</html>
