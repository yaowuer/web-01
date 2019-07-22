package com.nf152.web01.web.book.admin;

import com.nf152.web01.bean.book.Book;
import com.nf152.web01.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/book/admin/update")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取添加的页面
        Integer id = Integer.valueOf(req.getParameter("id"));

        Book book = DBUtil.queryOne(Book.class, "select * from book where id = ?", id);

        req.setAttribute("book", book);

        req.getRequestDispatcher("/WEB-INF/book/admin/bookUpdate.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 提交保存数据
        req.setCharacterEncoding("UTF-8");

        Integer id = Integer.valueOf(req.getParameter("id"));
        String name = req.getParameter("name");
        String author = req.getParameter("author");
        String publisher = req.getParameter("publisher");
        Double price = Double.valueOf(req.getParameter("price"));
        Integer amount = Integer.valueOf(req.getParameter("amount"));
        String publishAt = req.getParameter("publishat");

        DBUtil.execute(
                "update book set name = ?, author = ?, publisher = ?, price = ?, amount = ?, publish_at = ? where id = ?",
                name, author, publisher, price, amount, publishAt, id);

        resp.sendRedirect(req.getContextPath() + "/book/admin/manage");   // 重定向，肯定是 GET 方法
    }
}
