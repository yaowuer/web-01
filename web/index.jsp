<%@ page import="java.sql.*" %>
<%@ page import="com.nf152.web01.util.DBUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Connection conn = null;
    Statement stmt = null;
    ResultSet resultSet = null;
    try {
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:e:/data/student.sqlite3");
        stmt = conn.createStatement();
        resultSet = stmt.executeQuery("select name, weixin from student");
        out.println("<html>");
        out.println("<head>");
        out.println("<style>");
        out.println("  table { border-collapse: collapse; }");
        out.println("  table, tr, td { border: 1px solid red; padding: 1em; }");
        out.println("</style>");
        out.println("</head><body>");
        out.println("<table>");
        while (resultSet.next()) {
            out.println("<tr>");
            out.println("<td>" + resultSet.getString(1) + "</td><td>" + resultSet.getString(2) + "</td>");
            out.println("</tr>");
        }

    } catch (ClassNotFoundException e) {
    out.println("驱动没找到.");
    } catch (SQLException ex) {
    out.println("数据库错误: " + ex.getMessage());
    } finally {
    DBUtil.close(conn, stmt, resultSet);
    }
    out.println("</table>");
%>


<form method="post" action="/w1/hhh">
    <input type="submit" />
</form>

<%

    out.println("</body>");
    out.println("</html>");
%>