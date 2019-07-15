package com.nf152.web01.web.student;

import com.nf152.web01.bean.Student;
import com.nf152.web01.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/student/lst")
public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> students = new ArrayList<>();

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select id, name, weixin, score from student");

            while (rs.next()) {
                Student student = new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4));
                students.add(student);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBUtil.close(conn, stmt, rs);
        }

        req.setAttribute("aaa", students);
        req.getRequestDispatcher("/WEB-INF/student/bookManager.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
