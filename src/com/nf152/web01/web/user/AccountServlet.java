package com.nf152.web01.web.user;


import com.nf152.web01.bean.Account;
import com.nf152.web01.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/regist")
public class AccountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/user/regist.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Account account = DBUtil.queryOne(Account.class, "select * from account where username = ?", username);
        if (account != null) {
            req.setAttribute("errMsg", "该用户已经被注册!");
            req.getRequestDispatcher("/WEB-INF/user/regist.jsp").forward(req, resp);
            return;
        }

        try {
            DBUtil.execute("insert into account values (?, ?, ?)",
                    username, password, "1");
        } catch (Exception ex) {
            req.setAttribute("errMsg", "注册失败，请重试!");
            req.getRequestDispatcher("/WEB-INF/user/regist.jsp").forward(req, resp);
            return;
        }

        resp.sendRedirect(req.getContextPath() + "/");
    }
}
