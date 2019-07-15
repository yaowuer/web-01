package com.nf152.web01.web.student;

import com.nf152.web01.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;


@WebServlet("/student/add")
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取添加的页面
        req.getRequestDispatcher("/WEB-INF/student/stuAdd.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 提交保存数据
        req.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        String weixin = req.getParameter("weixin");
        float score = Float.parseFloat(req.getParameter("score"));

        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = DBUtil.getConnection();
            st = conn.prepareStatement("insert into student (name, weixin, score) values (?, ?, ?)");
            st.setString(1, name);
            st.setString(2, weixin);
            st.setFloat(3, score);
            st.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, st, null);
        }
        resp.sendRedirect(req.getContextPath() + "/student/lst");   // 重定向，肯定是 GET 方法
    }
}
