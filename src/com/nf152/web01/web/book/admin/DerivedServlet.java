package com.nf152.web01.web.book.admin;

import com.nf152.web01.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/book/user/delivered")
public class DerivedServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        DBUtil.execute("update dingdan set status = 3 where id = ?", id);
        resp.sendRedirect(req.getContextPath() + "/book/admin/orderManger");
    }
}
