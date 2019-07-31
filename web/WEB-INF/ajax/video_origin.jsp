<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>视频播放</title>
    <style>
        #comments {
            max-height: 100px;
            overflow-y: auto;
        }
    </style>
</head>
<body>

<div style="display: flex; flex-flow: row nowrap">
    <section style="margin: 1em;">
        <video width="200" controls="controls" src="${pageContext.request.contextPath}/assets/aaa.mp4"></video>
    </section>

    <section>
        <h3>评论内容</h3>
        <ul id="comments">
        </ul>

        <div>
            <textarea name="content"></textarea>
            <button onclick="doSubmitComment()">提交评论</button>
        </div>
    </section>
</div>

<script>

    function loadComments() {
        var xhr = new XMLHttpRequest();
        xhr.open("GET", "${pageContext.request.contextPath}/ajax/comment");
        xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        xhr.send(null);

        xhr.onload = function (ev) {
            var comments = document.querySelector("#comments");
            comments.innerHTML = this.responseText;
            comments.scrollTo(0, comments.scrollHeight);
        };
    }

    function doSubmitComment() {
        var content = document.querySelector("textarea");
        var comments = document.querySelector("#comments");

        var xhr = new XMLHttpRequest();
        xhr.open("POST", "${pageContext.request.contextPath}/ajax/comment");

        xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        xhr.send("content=" + content.value);

        xhr.onload = function (ev) {
            content.value = "";
            loadComments();
        };
    }

    window.onload = function (ev) {
        loadComments();
    };
</script>

</body>
</html>
