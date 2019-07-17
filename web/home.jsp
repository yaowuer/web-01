<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生管理系统 | 首页</title>
</head>
<body>

<div class="main">
    <nav>
        <h3>菜单</h3>
        <ul>
            <li><a href="${pageContext.request.contextPath}/student/lst">学生管理</a> </li>
            <li><a href="${pageContext.request.contextPath}/book/manage">图书系统（管理端）</a> </li>
            <li><a href="${pageContext.request.contextPath}/book/index">图书系统（用户端）</a> </li>
            <li><a href="#">其他功能</a></li>
            <li><a href="${pageContext.request.contextPath}/test">测试</a></li>
        </ul>
        <h3>其他</h3>
        <ul>
            <li><a href="${pageContext.request.contextPath}/basic/jstl">JSTL 示例</a> </li>
        </ul>
    </nav>
</div>

</body>
</html>
