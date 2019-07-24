package com.nf152.web01.web.book.admin;

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

@WebServlet("/fahuo")
public class FahuoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");
        String sql = "update dingdan set status = 3 where id =?";
        int aaa = DBUtil.execute(sql,id);
        resp.sendRedirect(req.getContextPath()+"/AdminOrder");

    }

}
