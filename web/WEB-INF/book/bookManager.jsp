<%@ page import="com.nf152.web01.bean.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="com.nf152.web01.bean.Book" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书籍管理</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/common.css">
    <style>
        table {
            width: 900px;
        }
    </style>
</head>
<body>

<h3>书籍管理</h3>

<table class="tb">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>author</th>
        <th>publisher</th>
        <th>price</th>
        <th>amount</th>
        <th>publish publishAt</th>
        <th>action</th>
    </tr>
    <%
        List<Book> books = (List<Book>) request.getAttribute("aaa");
        for (Book book : books) {
            out.print("<tr>");
            out.print("<td>" + book.getId() + "</td>");
            out.print("<td>" + book.getName() + "</td>");
            out.print("<td>" + book.getAuthor() + "</td>");
            out.print("<td>" + book.getPublisher() + "</td>");
            out.print("<td>" + book.getPrice() + "</td>");
            out.print("<td>" + book.getAmount() + "</td>");

            String dateStr = new SimpleDateFormat("yyyy-MM-dd").format(book.getPublishAt());

            out.print("<td>" + dateStr + "</td>");
            out.print("<td>" +
                    "<a href='" + request.getContextPath() + "/book/del?id=" + book.getId() + "'>删除</a>&nbsp;&nbsp;" +
                    "<a href='" + request.getContextPath() + "/book/update?id=" + book.getId() + "'>修改</a>" +
                    "</td>");

            out.print("</tr>");
        }
    %>
</table>

<section>
    <a href="<%= request.getContextPath() %>/book/add">添加学生信息</a>
</section>

</body>
</html>
