package com.nf152.web01.web.book;

import com.nf152.web01.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/book/add")
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取添加的页面
        req.getRequestDispatcher("/WEB-INF/book/bookAdd.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 提交保存数据
        req.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        String author = req.getParameter("author");
        String publisher = req.getParameter("publisher");
        Double price = Double.valueOf(req.getParameter("price"));
        Integer amount = Integer.valueOf(req.getParameter("amount"));
        String publishAt = req.getParameter("publishat");

        DBUtil.execute(
                "insert into book (name, author, publisher, price, amount, publish_at) values (?, ?, ?, ?, ?, ?)",
                name, author, publisher, price, amount, publishAt);

        resp.sendRedirect(req.getContextPath() + "/book/manage");   // 重定向，肯定是 GET 方法
    }
}
