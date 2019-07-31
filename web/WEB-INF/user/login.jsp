<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>用户登录</title>
    <style>
        * {
            padding: 0;
            margin: 0;
            box-sizing: border-box;
        }
        body {
            width: 100vw;
            background-image: linear-gradient(120deg, darkblue, darkred);
            display: flex;
            justify-content: center;
            flex-direction: column;
        }
        form {
            width: 320px;
            height: 350px;
            background: #f1f1f1;
            border-radius: 5px;
            padding: 30px;
            margin: 10px auto;
        }
        form h3 {
            text-align: center;
            margin-bottom: 10px;
        }
        .ib {
            position: relative;
            margin: 30px 0;
            border-bottom: 2px solid #d1d1d1;
        }
        .ib input {
            border: none;
            background: none;
            outline: none;
            height: 40px;
            width: 100%;
            padding: 5px 10px;
        }
        .ib span::before {
            content: attr(data-placeholder);
            position: absolute;
            left: 0;
            top: 50%;
            transform: translate(0, -50%);
            z-index: 0;
            color: gray;
            font-size: 0.8em;
            transition: 0.8s;
        }
        .ib span::after {
            content: "";
            height: 2px;
            width: 0;
            position: absolute;
            background-image: linear-gradient(100deg, red, yellow, darkblue);
            transition: 0.5s;
        }
        .focus + span::before {
            top: -5px;
        }
        .focus + span::after {
            width: 100%;
        }
        button {
            display: block;
            width: 100%;
            height: 40px;
            background-image: linear-gradient(90deg, darkgreen, darkred, darkblue);
            background-size: 200%;
            color: white;
            border: none;
            cursor: pointer;
            transition: 0.5s;
            margin-top: 30px;
        }
        button:hover {
            background-position: right;
        }
        .rg {
            text-align: center;
            margin-top: 20px;
        }
    </style>
</head>
<body>

<c:if test="${errMsg != null}">
    <div style="color: red; border: 1px solid red; border-radius: 3px; padding: 5px">
            ${errMsg}
    </div>
</c:if>

<form method="post" action="login">
    <h3>登录</h3>
    <div class="ib">
        <input id="un" name="username" />
        <span data-placeholder="Username"></span>
    </div>
    <div class="ib">
        <input id="pw" name="password" type="password" />
        <span data-placeholder="Password"></span>
    </div>
    <input type="hidden" name="back_url" value="${param["back_url"]}">

    <button onclick="doLogin()">点击登录</button>

    <div class="rg">
        如果没有注册，请点击 <a href="#">注册</a>
    </div>
</form>



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

    window.onload = function (ev) {
        var nodeListOf = document.querySelectorAll("input");
        nodeListOf.forEach(function (o) {
            o.onfocus = function (ev) {
                ev.target.classList.add("focus");
            };
            o.onblur = function (ev) {
                if (!ev.target.value) {
                    ev.target.classList.remove("focus");
                }
            }
        });
    };
</script>

</body>
</html>
