<%@ page import="com.nf152.web01.util.DBUtil" %>
<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我是一个示例</title>
    <style>

        table {
            width: 80%;
            margin: auto;
            border-collapse: collapse;
        }

        table, tr, th, td {
            border: 1px solid grey;
            padding: 5px 15px;
        }

        .del {
            text-align: center;
            text-shadow: 1px 1px 1px red;
            cursor: pointer;
        }
    </style>
</head>

<%
    String name = "NF152";

    // application
    application.setAttribute("aaa", "bbb");
    application.getAttribute("aaa");

    // request, response

    // config, 当前 Servlet 的相关信息与配置
    System.out.println(config.getServletName());

    // cookie->session
    Object xxx = session.getAttribute("xxx");
    if (xxx == null) {
        System.out.println("开始保存...");
        session.setAttribute("xxx", System.currentTimeMillis());
    } else {
        System.out.println("当前保存的 session 为: " + xxx);
    }

    // pageContext

    // ServletContext
%>

<body>

<h1>我们班的名字为: <%= name %>
</h1>

<div>
    <a href="<%= request.getContextPath() %>/students">点击查看所有学生的信息</a>
</div>

<div>
    <h3>这是一个 form 表单</h3>
    <form method="get" action="<%= request.getContextPath() %>/hhh">
        <input type="submit"/>
    </form>
</div>

<table id="mytable">
    <tr>
        <th>姓名</th>
        <th>分数</th>
        <th>操作</th>
    </tr>
    <%
        Connection conn = null;
        Statement stmt = null;
        ResultSet resultSet = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:e:/data/student.sqlite3");
            stmt = conn.createStatement();
            resultSet = stmt.executeQuery("select name, score from student");
            while (resultSet.next()) {
    %>
    <tr>
        <td><%= resultSet.getString(1) %>
        </td>
        <td><%= resultSet.getString(2) %>
        </td>
        <td class="del confirm">删除</td>
    </tr>

    <%
            }
        } catch (ClassNotFoundException e) {
            out.println("驱动没找到.");
        } catch (SQLException ex) {
            out.println("数据库错误: " + ex.getMessage());
        } finally {
            DBUtil.close(conn, stmt, resultSet);
        }
    %>
</table>

<script>
    // for (var i = 0; i < tagNames.length; i++) {
    //     var td = tagNames[i];
    //     // td.onclick = function (ev) {
    //     //     console.log(ev.target.innerHTML);
    //     // }
    //     td.addEventListener("click", function (ev) {
    //         console.log("..." + ev.target.innerHTML);
    //     }, false);
    // }

    // 1. 事件代理、事件委托
    // 2. 使用 class 样式类来区分不同的功能
    // 3. 对于删除这种比较严肃的操作，请务必让用户去手动确认，防止误操作
    // 4. dom 上面，删除节点的操作
    document.getElementById("mytable").addEventListener("click", function (ev) {
        if (ev.target.classList.contains("del") && window.confirm("是否真的要删除？")) {
            // var tr = ev.target.parentNode;
            // var tb = tr.parentNode;
            // tb.removeChild(tr);
            ev.target.parentNode.remove();
        }
    });

    // for (var i in tagNames) {
    //     tagNames[i].onclick = function () {
    //         alert(this.innerHTML);
    //     }
    // }
</script>
</body>
</html>