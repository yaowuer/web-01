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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet("/student/update")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取修改的页面

        String id = req.getParameter("id");

        Student student = null;
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("select id, name, weixin, score from student where id = " + id);
            if (rs.next()) {
                student = new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, st, rs);
        }

        req.setAttribute("stu", student);
        req.getRequestDispatcher("/WEB-INF/student/stuUpdate.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 对修改的数据进行提交
        req.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String weixin = req.getParameter("weixin");
        float score = Float.parseFloat(req.getParameter("score"));

        Connection conn = null;
        Statement st = null;
        try {
            conn = DBUtil.getConnection();
            st = conn.createStatement();
            String sql = "update student set name = '" + name + "', weixin = '" + weixin + "', score=" + score + " where id = " + id;
            System.out.println(sql);
            int count = st.executeUpdate(sql);
            System.out.println("有 " + count + " 行被修改了。");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, st, null);
        }

        String method = req.getMethod();

        // req.getRequestDispatcher("/student/lst").forward(req, resp); // 转发
        resp.sendRedirect(req.getContextPath() + "/student/lst");   // 重定向，肯定是 GET 方法
    }
}
