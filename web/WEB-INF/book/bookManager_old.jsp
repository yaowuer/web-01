<%@ page import="java.util.List" %>
<%@ page import="com.nf152.web01.bean.Book" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书籍管理</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/common.css">
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
    <h3>书籍管理</h3>
</header>
<div class="main">
    <aside>
        <ul>
            <li>书籍管理</li>
            <li>作者管理</li>
            <li>出版社管理</li>
            <li>订单管理</li>
            <li>用户管理</li>
            <li>系统设置</li>
        </ul>
    </aside>
    <section>
        <p>
            <a href="<%= request.getContextPath() %>/book/add">添加学生信息</a>
        </p>
        <table class="tb">
            <tr>
                <th>id</th>
                <th>name</th>
                <th>author</th>
                <th>publisher</th>
                <th>price</th>
                <th>amount</th>
                <th>publishAt</th>
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
                    out.print("<td>" + book.getPublishAt() + "</td>");
                    out.print("<td>" +
                            "<a href='" + request.getContextPath() + "/book/del?id=" + book.getId() + "'>删除</a>&nbsp;&nbsp;" +
                            "<a href='" + request.getContextPath() + "/book/update?id=" + book.getId() + "'>修改</a>" +
                            "</td>");
                    out.print("</tr>");
                }
            %>
        </table>
    </section>
</div>

</body>
</html>
