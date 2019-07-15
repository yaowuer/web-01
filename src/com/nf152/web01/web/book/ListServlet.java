package com.nf152.web01.web.book;

import com.nf152.web01.bean.Book;
import com.nf152.web01.bean.Student;
import com.nf152.web01.dao.BookDAO;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/book/lst")
public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookDAO bookDAO = new BookDAO();
        List<Book> books = bookDAO.list();

        req.setAttribute("aaa", books);
        req.getRequestDispatcher("/WEB-INF/book/bookManager.jsp").forward(req, resp);
    }
}
