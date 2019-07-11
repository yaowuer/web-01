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

        String output = "";
        output += "<html>";
        output += "<head>";
        output += "<style>";
        output += "  table { border-collapse: collapse; }";
        output += "  table, tr, td { border: 1px solid red; padding: 1em; }";
        output += "</style>";
        output += "</head><body>";
        output += "<table>";

        String alertContent = "";
        while (resultSet.next()) {
            output += "<tr>";
            output += "<td onclick=\"alert('"+resultSet.getString(1)+"')\">" + resultSet.getString(1) + "</td><td>" + resultSet.getString(2) + "</td>";
            output += "</tr>";
            alertContent += resultSet.getString(1) + ":";
        }
        output += "</table>";
        output += "<script>";
        output += "" +
                "var aaa = '" + alertContent + "';" +
                "alert(aaa);" +
                "}";
        output += "</script>";
        output += "</body>";
        output += "</html>";

        System.out.println(output);
        out.println(output);
    } catch (ClassNotFoundException e) {
        out.println("驱动没找到.");
    } catch (SQLException ex) {
        out.println("数据库错误: " + ex.getMessage());
    } finally {
        DBUtil.close(conn, stmt, resultSet);
    }
%>