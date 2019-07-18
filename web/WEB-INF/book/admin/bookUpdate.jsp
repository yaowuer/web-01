<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书修改</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/common.css">
</head>
<body>

<h3>图书修改</h3>

<div>
    <form class="frm" method="post" action="update">
        <label>
            <span>Name:</span>
            <input name="name" value="${book.name}">
        </label>
        <label>
            <span>Author:</span>
            <input name="author" value="${book.author}">
        </label>
        <label>
            <span>Publisher:</span>
            <input name="publisher" value="${book.publisher}">
        </label>
        <label>
            <span>Price:</span>
            <input name="price" value="${book.price}">
        </label>
        <label>
            <span>Amount:</span>
            <input name="amount" value="${book.amount}">
        </label>
        <label>
            <span>Publish Date:</span>
            <input type="date" name="publishat" value="${book.publishAt}">
        </label>
        <input type="hidden" name="id" value="${book.id}">
        <input type="submit" value="保存修改信息">
    </form>
</div>

<footer>
    <a href="lst">返回首页</a>
</footer>
</body>
</html>
