<%@ page import="com.nf152.web01.bean.Student" %>
<%@ page import="com.nf152.web01.bean.Book" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书修改</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/common.css">
</head>
<body>

<h3>图书修改</h3>

<%
        Book book = (Book) request.getAttribute("book");
%>

<div>
    <form class="frm" method="post" action="add">
        <label>
            <span>Name:</span>
            <input name="name" value="<%= book.getName()%>">
        </label>
        <label>
            <span>Author:</span>
            <input name="author" value="<%= book.getAuthor()%>">
        </label>
        <label>
            <span>Publisher:</span>
            <input name="publisher" value="<%= book.getPublisher()%>">
        </label>
        <label>
            <span>Price:</span>
            <input name="price" value="<%= book.getPrice()%>">
        </label>
        <label>
            <span>Amount:</span>
            <input name="amount" value="<%= book.getAmount()%>">
        </label>
        <label>
            <span>Publish Date:</span>
            <input name="publishat" value="<%= book.getPublishAt()%>">
        </label>
        <input type="hidden" name="id">
        <input type="submit" value="保存修改信息">
    </form>
</div>


<footer>
    <a href="lst">返回首页</a>
</footer>
</body>
</html>
