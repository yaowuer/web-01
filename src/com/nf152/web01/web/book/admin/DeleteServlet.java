package com.nf152.web01.web.book.admin;

import com.nf152.web01.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/book/admin/del")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        DBUtil.execute("delete from book where id = ?", id);
        resp.sendRedirect(req.getContextPath() + "/book/admin/manage");
    }
}
