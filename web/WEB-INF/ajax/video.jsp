<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>视频播放</title>
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.js"></script>
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
    function loadComments1 () {
        $.ajax({
            method: "GET",
            url: "${pageContext.request.contextPath}/ajax/comment"
        }).done(function (res) {
            $("#comments").html(res).scrollTop(999);
        });
    }

    function loadComments() {
        $.get("${pageContext.request.contextPath}/ajax/comment", function (res) {
            $("#comments").html(res).scrollTop(999);
            //$("#comments").get(0).scrollTo(0, comments.scrollHeight);
        })
    }

    function loadComments3() {
        $("#comments").load("${pageContext.request.contextPath}/ajax/comment");
    }

    function doSubmitComment() {
        $.ajax({
            method: "POST",
            url: "${pageContext.request.contextPath}/ajax/comment",
            data: {
                content: $("textarea").val()
            }
        }).done(function (res) {
            $("textarea").val("");
            loadComments();
        }).fail(function () {
            alert("添加失败！")
        });

        // $.post(url, callback, error);
    }

    window.onload = function (ev) {
        loadComments();
    };
</script>

</body>
</html>
