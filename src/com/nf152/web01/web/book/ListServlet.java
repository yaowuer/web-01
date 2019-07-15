package com.nf152.web01.web.book;

import com.nf152.web01.bean.Book;
import com.nf152.web01.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/book/manage")
public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        BookDAO bookDAO = new BookDAO();
//        List<Book> books = bookDAO.list();

        req.setAttribute("aaa", DBUtil.queryList(Book.class, "select * from book"));
        req.getRequestDispatcher("/WEB-INF/book/bookManager.jsp").forward(req, resp);
    }
}
