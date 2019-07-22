<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我看到的货架</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/common.css">
    <style>
        img {
            height: 100px;
        }

        .main {
            width: 900px;
            margin: auto;
        }

        .lst {
            display: flex;
            flex-flow: row wrap;
        }

        .goods {
            border: 1px solid gray;
            padding: 10px;
            margin: 10px;

        }

        .mycart {
            border: 1px solid gray;
            border-radius: 5px;
            background: white;
            padding: 15px;

            position: fixed;
            right: 10px;
            top: 40px;

            display: ${param.showCart != 1 ? 'none' : 'block'};
        }

        .cart-tb {
            width: 550px;
        }

        .summary {
            padding-left: 15px;
        }
    </style>
</head>
<body>

<c:set var="root" value="${pageContext.request.contextPath}" scope="page"/>

<div class="mycart">
    <jsp:include page="2-listCart.jsp"/>
</div>

<header style="display: flex; flex-flow: row; justify-content: space-between">
    <div>
        <c:if test="${sessionScope.account != null}">
            <span>欢迎您 ${sessionScope.account.username}</span>
            <a href="${root}/user/logout">注销</a>
        </c:if>
        <c:if test="${sessionScope.account == null}">
            <a href="${root}/user/login">登录/注册</a>
        </c:if>
    </div>
    <div>
        <a id="displayCart" href="#">查看购物车</a>
        <a href="${root}/book/user/lstOrder">订单查询</a>
    </div>
</header>

<div class="main">
    <section>
        <h3>热门推荐</h3>
        <div class="lst">
            <c:forEach var="book" items="${books}">
                <c:if test="${book.price > 50}">
                    <div class="goods">
                        <header>${book.name}</header>
                        <p><img src="${root}/assets/apple.jpg"></p>
                        <footer>
                            <span>￥${book.price}元</span>
                            <a href="${root}/book/user/addCart?id=${book.id}">加入购物车</a>
                        </footer>
                    </div>
                </c:if>
            </c:forEach>
        </div>
    </section>
    <section>
        <h3>所有书籍</h3>
        <div class="lst">
            <c:forEach var="book" items="${books}">
                <div class="goods">
                    <header>${book.name}</header>
                    <p><img src="${root}/assets/apple.jpg"></p>
                    <footer>
                        <span>￥${book.price}元</span>
                        <a href="${root}/book/user/addCart?id=${book.id}">加入购物车</a>
                    </footer>
                </div>
            </c:forEach>
        </div>
    </section>
</div>

<script>
    document.querySelector("#displayCart").addEventListener("click", function (evt) {
        evt.preventDefault();
        var cart = document.querySelector(".mycart");
        var display = cart.style.display;
        cart.style.display = display === 'block' ? 'none' : 'block';
    });
</script>

</body>
</html>
