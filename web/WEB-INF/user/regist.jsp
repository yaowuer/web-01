<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
    <script src="${pageContext.request.contextPath}/assets/jquery.js"></script>
</head>
<body>

<c:if test="${errMsg != null}">
    <div style="color: red; border: 1px solid red; border-radius: 3px; padding: 5px">
            ${errMsg}
    </div>
</c:if>

<form method="post" action="regist">
    <div>
        <input id="un" name="username" placeholder="请输入用户名"/>
    </div>
    <div>
        <input id="pw1" name="password" type="password" placeholder="请输入密码"/>
    </div>
    <div>
        <input id="pw2" type="password" placeholder="请再次输入密码"/>
    </div>
</form>

<button onclick="doRegist()">点击注册</button>

<script>
    $(function () {
        $("#un").on("change", function () {
            $input = $(this);
            $.ajax({
                method: "POST",
                url: "${pageContext.request.contextPath}/user/checkUser",
                data: {username: $input.val()}
            }).done(function (res) {
                if (res === "err") {
                    $input.after($("<span style='color: red'>用户已经存在</span>"));
                } else {
                    $input.parent().find("span").remove();
                }
            });
        });
    });

    function doRegist() {
        var uname = document.querySelector("#un");
        var pw1 = document.querySelector("#pw1");
        var pw2 = document.querySelector("#pw2");

        if (uname.value.length <= 4) {
            alert("用户名必须要大于 4 位");
        } else if (!pw1.value) {
            alert("密码不能为空");
        } else if (pw1.value !== pw2.value) {
            alert("请输入正确的密码");
            pw1.value = "";
            pw2.value = "";
            pw1.focus();
        } else {
            document.querySelector("form").submit();
        }
    }
</script>

</body>
</html>
