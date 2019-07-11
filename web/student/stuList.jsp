<%@ page import="com.nf152.web01.bean.Student" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生列表</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/common.css">
</head>
<body>

<h3>学生列表</h3>

<table class="tb">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>weixin</th>
        <th>score</th>
        <th>op</th>
    </tr>
    <%
        List<Student> students = (List<Student>) request.getAttribute("aaa");
        for (Student student : students) {
            out.print("<tr>");
            out.print("<td>" + student.getId() + "</td>");
            out.print("<td>" + student.getName() + "</td>");
            out.print("<td>" + student.getWeixin() + "</td>");
            out.print("<td>" + student.getScore() + "</td>");
            out.print("<td>" +
                    "<a href='" + request.getContextPath() + "/student/del?id=" + student.getId() + "'>删除</a>&nbsp;&nbsp;" +
                    "<a href='" + request.getContextPath() + "/student/update?id=" + student.getId() + "'>修改</a>" +
                    "</td>");

            out.print("</tr>");
        }
    %>
</table>

<section>
    <a href="<%= request.getContextPath() %>/student/add">添加学生信息</a>
    <a href="<%= request.getContextPath() %>/student/del?id=-1">删除所有学生</a>
</section>

</body>
</html>
