<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>支付页面</title>
    <style>
        img {
            width: 200px;
            height: 200px;
        }
    </style>
</head>
<body>

请打开手机，进行扫码支付。

<div>

    <img id="qrcode" src="${pageContext.request.contextPath}/assets/qrcode.png">

</div>

<script>
    document.querySelector("#qrcode").addEventListener('click', function (evt) {
        if (window.confirm("你是不是真的要进行支付?")) {
            window.location.href = "${pageContext.request.contextPath}/book/paySuccess";
        }
    });
</script>

</body>
</html>
