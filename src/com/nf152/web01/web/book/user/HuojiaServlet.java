package com.nf152.web01.web.book.user;


import com.nf152.web01.bean.book.Book;
import com.nf152.web01.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/book/user/index")
public class HuojiaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("books", DBUtil.queryList(Book.class, "select * from book"));
        req.getRequestDispatcher("/WEB-INF/book/user/1-huojia.jsp").forward(req, resp);
    }
}
