<%@ page import="com.nf152.web01.bean.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生信息修改</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/common.css">
</head>
<body>

<h3>学生信息</h3>

<%
    Student student = (Student) request.getAttribute("stu");

    if (student != null) {
%>

<div>
    <form class="frm" method="post" action="update">
        <label>
            <span>ID:</span>
            <input name="id" value="<%=student.getId()%>" readonly>
        </label>
        <label>
            <span>Name:</span>
            <input name="name" value="<%=student.getName()%>">
        </label>
        <label>
            <span>Weixin:</span>
            <input name="weixin" value="<%=student.getWeixin()%>">
        </label>
        <label>
            <span>Score:</span>
            <input name="score" value="<%=student.getScore()%>">
        </label>
        <input type="submit" value="提交修改信息">
    </form>
</div>

<%
    } else {
%>
    <div>此 ID 没有找到相关的数据，所以不能进行修改。</div>
<%
    }
%>


<footer>
    <a href="lst">返回首页</a>
</footer>
</body>
</html>
