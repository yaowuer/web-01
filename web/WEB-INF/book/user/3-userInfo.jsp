<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发货信息</title>
    <style>
        form > div {
            margin: 20px;
        }
        form select {
            padding: 3px 5px;
            background: aliceblue;
        }
    </style>
</head>
<body>

<div>
    <h3>
        请输入您的收获信息:
    </h3>
    <form method="get" action="pay">
        <div>
            <label>
                您的姓名: <input name="username">
            </label>
            <label>
                您的联系: <input name="telphone">
            </label>
        </div>

        <div>
          <%@include file="addressField.jsp" %>
        </div>
    </form>

    <button onclick="doSubmit()">下一步</button>
</div>

<script>
    // 提交之前，需要若干校验
    function doSubmit() {
        var province = document.querySelector("#province");
        var city = document.querySelector("#city");

        if (!province.value) {
            alert("请选择合适的省。");
            province.focus();
            return;
        }

        if (!city.value) {
            alert("请选择合适的市。");
            city.focus();
            return;
        }

        document.querySelector("form").submit();
    }
</script>

</body>
</html>
