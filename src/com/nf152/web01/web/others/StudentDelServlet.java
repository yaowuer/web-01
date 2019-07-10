package com.nf152.web01.web.others;

import com.nf152.web01.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/studentdel")
public class StudentDelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:e:/data/student.sqlite3");
            stmt = conn.createStatement();
            stmt.execute("delete from student where id=" + id);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBUtil.close(conn, stmt, null);
        }

        // 转发
        req.getRequestDispatcher("/students").forward(req, resp);
    }
}
