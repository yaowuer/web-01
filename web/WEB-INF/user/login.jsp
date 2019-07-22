<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>用户登录</title>
</head>
<body>

<c:if test="${errMsg != null}">
    <div style="color: red; border: 1px solid red; border-radius: 3px; padding: 5px">
            ${errMsg}
    </div>
</c:if>

<form method="post" action="login">
    <div>
        <input id="un" name="username" placeholder="请输入用户名" />
    </div>
    <div>
        <input id="pw" name="password" type="password" placeholder="请输入密码" />
    </div>
    <input type="hidden" name="back_url" value="${param["back_url"]}">
</form>

<button onclick="doLogin()">点击登录</button>

<script>
    function doLogin() {
        var uname = document.querySelector("#un");
        var pw = document.querySelector("#pw");

        if (uname.value.length <= 4) {
            alert("用户名必须要大于 4 位");
        } else if (!pw.value) {
            alert("密码不能为空");
        } else {
            document.querySelector("form").submit();
        }
    }
</script>

</body>
</html>
