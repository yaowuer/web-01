package com.nf152.web01.web;

import com.nf152.web01.bean.Book;
import com.nf152.web01.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet("/test")
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Book> books = DBUtil.queryList(Book.class, "select * from book");
        req.setAttribute("books", books);

        req.setAttribute("ddd", new Date());

        req.getRequestDispatcher("/test.jsp").forward(req, resp);
    }
}
