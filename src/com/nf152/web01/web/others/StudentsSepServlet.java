package com.nf152.web01.web.others;

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

@WebServlet("/stus")
public class StudentsSepServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 准备数据 （获取、过滤、转换）
        List<Student> students = new ArrayList<>();

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select id, name, weixin, score from student");

            while (rs.next()) {
                Student student = new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4));
                students.add(student);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBUtil.close(conn, stmt, rs);
        }

        // 将 students 数据，保存到 req 对象里面，保存的名字为 aaa
        req.setAttribute("aaa", students);

        // 将渲染的工作交给更专业的去做，转发
        req.getRequestDispatcher("/bookManager.jsp").forward(req, resp);
    }
}
