<%@ page import="com.nf152.web01.bean.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书添加</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/common.css">
</head>
<body>

<h3>图书添加</h3>

<div>
    <form class="frm" method="post" action="add">
        <label>
            <span>Name:</span>
            <input name="name">
        </label>
        <label>
            <span>Author:</span>
            <input name="author">
        </label>
        <label>
            <span>Publisher:</span>
            <input name="publisher">
        </label>
        <label>
            <span>Price:</span>
            <input name="price">
        </label>
        <label>
            <span>Amount:</span>
            <input name="amount">
        </label>
        <label>
            <span>Publish Date:</span>
            <input name="publishat">
        </label>
        <input type="submit" value="保存图书信息">
    </form>
</div>


<footer>
    <a href="lst">返回首页</a>
</footer>
</body>
</html>
