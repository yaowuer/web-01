package com.nf152.web01.web.ajax;

import com.nf152.web01.bean.Comment;
import com.nf152.web01.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ajax/comment")
public class CommentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Comment> comments = DBUtil.queryList(Comment.class, "select * from comment");
        req.setAttribute("comments", comments);

        req.getRequestDispatcher("/WEB-INF/ajax/comment.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String content = req.getParameter("content");
        DBUtil.execute("insert into comment (content) values (?)", content);
    }
}
