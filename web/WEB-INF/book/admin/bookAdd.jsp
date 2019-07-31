<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书添加</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/common.css">
</head>
<body>

<h3>图书添加</h3>

<div>
    <form class="frm" method="post" action="add" enctype="multipart/form-data">
        <label>
            <span>Name:</span>
            <input name="name">
        </label>
        <label>
            <span>Author:</span>
            <input id="author" name="author">
        </label>
        <label>
            <span>Publisher:</span>
            <input name="publisher">
        </label>
        <label>
            <span>Price:</span>
            <input name="price">
        </label>
        <label>
            <span>Amount:</span>
            <input name="amount">
        </label>
        <label>
            <span>Cover:</span>
            <input name="cover" type="file">
        </label>
        <label>
            <span>Publish Date:</span>
            <input type="date" name="publishat">
        </label>

        <input type="submit" value="保存图书信息">
    </form>
</div>

<script>
    function doSubmitBook() {
        var author = document.querySelector("#author");
        if (!author.value.trim()) {
            alert("作者不能为空")
            author.focus();
            return;
        }
    }
</script>

<footer>
    <a href="manage">返回首页</a>
</footer>
</body>
</html>
