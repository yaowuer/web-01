package com.nf152.web01.web.basic;

import com.nf152.web01.bean.Book;
import com.nf152.web01.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/basic/jstl")
public class JstlServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Book> books = DBUtil.queryList(Book.class, "select * from book");
        req.setAttribute("books", books);
        req.setAttribute("ddd", new Date());

        HttpSession session = req.getSession(); // 跟你的 JSESSIONID
        session.setAttribute("sess1", "session test");

        // 获取 session 的有效时间，单位是 秒
        System.out.println(session.getMaxInactiveInterval());

        // 让当前用户的 session 失效
        // session.invalidate();

        req.getRequestDispatcher("/WEB-INF/basic/jstl.jsp").forward(req, resp);
    }
}
