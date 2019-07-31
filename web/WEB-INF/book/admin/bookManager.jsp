<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}" scope="page"/>
<html>
<head>
    <title>书籍管理</title>
    <link rel="stylesheet" href="${root}/assets/common.css">
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
    <style>
        .tb {
            width: 90%;
        }

        .main {
            display: flex;
            flex-flow: nowrap row;
            width: 100%;
        }

        .main > aside {
            flex: 0 0 150px;
        }

        .main > section {
            flex: 1;
        }
        .xxx {
            background: greenyellow;
            font-weight: bolder;
            font-style: italic;
        }
        .yyy {
            color: red;
        }
    </style>
</head>
<body>
<header>
    <h1>书籍管理系统 <span style="font-size: 12px">欢迎您，管理员</span></h1>
</header>
<div class="main">
    <aside>
        <ul>
            <li>
                <a href="${root}/book/admin/manage">书籍管理</a>
            </li>
            <li>作者管理</li>
            <li>出版社管理</li>
            <li>
                <a href="${root}/book/admin/orderManger">订单管理</a>
            </li>
            <li>用户管理</li>
            <li>系统设置</li>
        </ul>
    </aside>
    <section>
        <p>
            <a href="${root}/book/admin/add">添加图书信息</a>
        </p>
        <table class="tb">
            <tr>
                <th>No.</th>
                <th>id</th>
                <th>name</th>
                <th>author</th>
                <th>publisher</th>
                <th>price</th>
                <th>amount</th>
                <th>publishAt</th>
                <th>action</th>
            </tr>
            <c:forEach var="book" varStatus="s" items="${aaa}">
                <tr>
                    <td>${s.count}</td>
                    <td>${book.id}</td>
                    <td>${book.name}</td>
                    <td>${book.author}</td>
                    <td>${book.publisher}</td>
                    <td>${book.price}</td>
                    <td>${book.amount}</td>
                    <td>${book.publishAt}</td>
                    <td>
                        <a href="${root}/book/admin/del?id=${book.id}">删除</a>
                        &nbsp;
                        <a href="${root}/book/admin/update?id=${book.id}">修改</a>
                    </td>
                </tr>
            </c:forEach>
            <c:if test="${empty aaa}">
                <tr>
                    <td colspan="9">没有任何书籍，可以先选择<a href="${root}/book/admin/add">添加</a></td>
                </tr>
            </c:if>
        </table>
    </section>
</div>

<script>

    $(function () {
        $("table tr:odd")
            .addClass("xxx")
            .click(function (e) {
                // 首先判断，是否存在 xxx 元素
                // 如果存在，移除；否则添加
                // var el = $(this);
                // if (el.hasClass("xxx")) {
                //     el.removeClass("xxx");
                // } else {
                //     el.addClass("xxx");
                // }
                $(this).toggleClass("xxx");
            });

        $("table tr:even")
            .addClass("yyy")
            .click(function (e) {
                $(this).removeClass("yyy")
            });


        $("h1").on('click', function (event) {

            // 事件的回调函数里面
            // this 代表原生的 DOM 节点数组
            // $(this) 则取到的是 jQuery 数组
            $(this).css("font-size", "3em");
        });
    });
</script>

</body>
</html>
