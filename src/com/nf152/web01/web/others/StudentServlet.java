package com.nf152.web01.web.others;

import com.nf152.web01.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class StudentServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 预准备工作
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8"); // MIME
        PrintWriter out = resp.getWriter();

        // 限制访问的 IP 地址
        String host = req.getHeader("Host");
        if (host != null && host.equals("127.0.0.1:8888")) {
            out.println("你不能直接使用 IP 地址去访问。");
            return;
        }

        // 合理的变量名
        // 使用合理的 API
        // 空指针异常
        // 学会逻辑的抽离、封装
        if (isIEBrowser(req.getHeader("User-Agent"))) {
            out.println("不能使用IE浏览器!");
            return;
        }

        // 准备数据 （获取、过滤、转换）
        String data1 = "";
        String bgColor = "gray", fontSize = "12px";

        Connection conn = null;
        Statement stmt = null;
        ResultSet resultSet = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:e:/data/student.sqlite3");
            stmt = conn.createStatement();
            resultSet = stmt.executeQuery("select name, score, weixin, id from student");

            while (resultSet.next()) {
                data1 += "<tr><td>" + resultSet.getString(1)
                        + "</td><td>" + resultSet.getString(2)
                        + "</td><td class='del'>"
                        + "<a href='/w1/student/del?id=" + resultSet.getInt(4) + "'>删除</a></td></tr>\n";
            }

            resultSet = stmt.executeQuery("select attr, val from hstyle");
            while (resultSet.next()) {
                if (resultSet.getString(1).equals("bgcolor")) {
                    bgColor = resultSet.getString(2);
                }
                if (resultSet.getString(1).equals("fontsize")) {
                    fontSize = resultSet.getString(2);
                }
            }

        } catch (ClassNotFoundException e) {
            data1 = "<tr><td>驱动没找到.</td></tr>\n";
        } catch (SQLException ex) {
            ex.printStackTrace();
            data1 = "<tr><td>连接异常 " + ex.getMessage() + "</td></tr>\n";
        } finally {
            DBUtil.close(conn, stmt, resultSet);
        }

        // 输出数据 （格式化，输出）
        out.println("<html>");
        out.println("<head>");
        out.println("<style>");
        out.println("  body { background: " + bgColor + "; }");
        out.println("  table { font-size: " + fontSize + "; border-collapse: collapse; width: 500px; margin: auto; }");
        out.println("  table, tr, td { border: 1px solid gray; padding: 5px 10px; }");
        out.println("</style>");
        out.println("</head><body>");
        out.println("<h3>学生的列表</h3>");
        out.println("<table>");
        out.println(data1);
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }

    private boolean isIEBrowser (String userAgent) {
        if (userAgent != null) {
            return userAgent.contains("MSIE") || userAgent.contains("Trident");
        }
        return false;
    }
}
