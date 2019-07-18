<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生信息添加</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/common.css">
</head>
<body>

<h3>学生信息</h3>

<div>
    <form class="frm" method="post" action="add">
        <label>
            <span>Name:</span>
            <input name="name">
        </label>
        <label>
            <span>Weixin:</span>
            <input name="weixin">
        </label>
        <label>
            <span>Score:</span>
            <input name="score">
        </label>
        <input type="submit" value="保存学生信息">
    </form>
</div>


<footer>
    <a href="lst">返回首页</a>
</footer>
</body>
</html>
